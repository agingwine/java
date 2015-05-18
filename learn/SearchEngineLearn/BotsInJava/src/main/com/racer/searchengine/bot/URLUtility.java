package com.racer.searchengine.bot;

import java.io.*;
import java.net.*;

/**
 * This static class contains several methods that are useful to manipulate URL's.
 * 
 * @author Ren Wanchun
 * @version v1.0
 */


public class URLUtility{
	/**
	 * Private constructor prevent instanitation.
	 */
	private URLUtility()
  {
  }

  /**
   * Strip the query string from the URL
   * @param url The URL to examine
   * @return The URL without query string
   * @exception java.net.MalformedURLException
   */
  public static URL stripQuery(URL url)throws MalformedURLException{
  	String file = url.getFile();
  	int i = file.indexOf("?");
  	if(i == -1)
  		return url;
  	file = file.substring(0,i);
  	return new URL(url.getProtocol(),url.getHost(),url.getPort(),file);
  }

  /**
   * Strip the anchor tag from the URL.
   * @param url The URL to scan.
   * @return The URL with no anchor tag.
   * @exception MalformedURLException
   */
  public static URL stripAnchor(URL url)throws MalformedURLException{
  	String file = url.getFile();
  	return new URL(url.getProtocol(),url.getHost(),url.getPort(),file);
  }


  /**
   * Encode a string in base64
   * @param s The string to encode.
   * @return The encoded string.
   */
  public static String base64Encode(String s){
  	ByteArrayOutputStream bout = new ByteArrayOutputStream();

  	Base64OutputStream out = new Base64OutputStream(bout);
  	try{
  		out.write(s.getBytes());
  		out.flush();
  	}
  	catch(IOException e){
  	}
  	return bout.toString();
  }

  /**
   * Resolve the base of a URL.
   * @param base The base.
   * @param rel The relative path.
   * @param The combined absolute URL.
   */
  public static String resolveBase(String base,String rel){
  	String protocol;
  	int i = base.indexOf(':');
  	if(i != -1){
  		protocol = base.substring(0,i);
  		base = "http:"+base.substring(i+1);
  	}
  	else
  		protocol = null;
  	URL url;
  	try{
  		url = new URL(new URL(base),rel);
  	}
  	catch(MalformedURLException e){
  		return "";
  	}
  	if(protocol != null){
  		base = url.toString();
  		i = base.indexOf(':');
  		if(i != -1)
  			base = base.substring(i+1);
  		base = protocol +base;
  		return base;
  	}
  	else{
  		return url.toString();
  	}
  }
}