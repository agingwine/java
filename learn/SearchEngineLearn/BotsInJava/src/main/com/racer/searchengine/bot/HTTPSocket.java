package com.racer.searchengine.bot;
import java.net.*;
import java.io.*;

public class HTTPSocket extends HTTP{
	/**
	 * This method is called to write string to the output stream
	 * @param out The output sream
	 * @param str The string to be written
	 */
	public void writeString(OutputStream out,String str)throws java.io.IOException{
		out.write(str.getBytes());
		out.write("\r\n".getBytes());
		Log.log(Log.LOG_LEVEL_TRACE,"Socket out: "+str);
	}

	/**
	 * This method actually send the data to web server using HTTP protocol or HTTPS protocol
	 */
	public synchronized void lowLevelSend(String url,String post)
		throws java.net.UnknownHostException,java.io.IOException{
		String commmand;//What kind of send.POST or GET?
		StringBuffer headers;//Used to hold outgoing client headers
		byte buffer[] = new byte[1024];//A buffer for reading
		int len,i;//Counters
		Attribute a;//Used to process incoming attributes
		int port = 80;//HTTP protocol default port number
		boolean isHttps=false;//Are we using HTTPS?
		URL u;//Used to help parse the url parameter
		Socket socket = null;
		OutputStream out = null;
		InputStream in=null;

		//parse the url
		try{
			if(url.toLowerCase().startsWith("https:")){
				url = "http"+url.substring(5);//so we can use URL class to parse the url....
				u= new URL(url);
				if(u.getPort()==-1)
					port=443;
				isHttps=true;
			}
			else{
				u=new URL(url);
			}

			if(u.getPort()!=-1)
				port=u.getPort();

		// connect
			if(isHttps){
				//socket = SSL.getSSLSocket(u.getHost(),port);
			}
			else{
				socket = new Socket(u.getHost(),port);
			}
			socket.setSoTimeout(_timeout);
			out = socket.getOutputStream();
			in = socket.getInputStream();

		// process send commmand, i.e. GET or POST
			if(post==null)
				commmand="GET";
			else
				commmand="POST";
			String file = u.getFile();
			if(file.length()==0)
				file="/";
			commmand = commmand +file+" HTTP/1.0";
			writeString(out,commmand);

		// process client headers
			if(post !=null )
				writeString(out,"Content-Length: " + post.length());
			writeString(out,"Host: " + u.getHost());

			i=0;
			headers = new StringBuffer();
			do{
				a = _clientHeaders.get(i++);
				if(a!=null){
					headers.append(a.getName());
					headers.append(':');
					headers.append(a.getValue());
					headers.append("\r\n");
					Log.log(Log.LOG_LEVEL_TRACE,"Client Header:"+a.getName()+"="+a.getValue());
				}
			}while(a!=null);

			if(headers.length()>=0)
				out.write(headers.toString().getBytes());
		// Send a blank line to signal end of HTTP headers
			writeString(out,"");
			if(post!=null){
				Log.log(Log.LOG_LEVEL_TRACE,"Socket Post("+post.length()+" bytes): "+new String(post));
				out.write(post.getBytes());
			}

		// Read the result
		// First read HTTP headers
			_header.setLength(0);
			int chars=0;
			boolean done = false;
			while(!done){
				int ch;
				ch = in.read();
				if(ch==-1)
					done=true;
				switch(ch){
					case '\r':
						break;
					case '\n':
						if(chars==0)
							done=true;
						chars=0;
						break;
					default:
						chars++;
						break;
				}
				//read data to _header
				_header.append((char)ch);
			}

		// now parse the headers and get content length
			parseHeaders();
			Attribute acl = _serverHeaders.get("Content-length");
			int contentLength = 0;
			try{
				if(acl!=null)
					contentLength = Integer.parseInt(acl.getValue());
			}
			catch(Exception e){
				Log.logException("Bad value for content-length: ",e);
			}

		// get the body of HTTP response
			_body.setLength(0);
			int max=_maxBodySize;

			if(contentLength!=0){
				// read in using content length
				while((contentLength--)>0){
					len = in.read(buffer);
					if(len<0)
						break;
					_body.append(new String(buffer,0,len,"8859_1"));
					max--;
					if(max<0&&(_maxBodySize!=-1))
						break;
				}
			}
			else{
				//read in with no content length
				do{
					len=in.read(buffer);
					if(len<0)
						break;
					_body.append(new String(buffer,0,len,"8859_1"));
					max--;
					if(max<0&&(_maxBodySize!=-1))
						break;
				}while(len!=0);
			}
			Log.log(Log.LOG_LEVEL_DUMP,"Socket Page Back:"+_body+"\r\n");	
		}
		finally{
			if(out!=null){
				try{
					out.close();
				}
				catch(Exception e){
				}
			}

			if(in!=null){
				try{
					in.close();
				}
				catch(Exception e){
				}
			}
			if(socket!=null){
				try{
					socket.close();
				}
				catch(Exception e){
				}
			}
		}
	}

	/**
	 * Create a new copy of this HTTP handler
	 */
	HTTP copy(){
		return new HTTPSocket();
	}
}