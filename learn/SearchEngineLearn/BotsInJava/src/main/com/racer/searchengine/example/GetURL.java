package com.racer.searchengine.example;

/**
 * 使用URL类打开web页面并下载内容
 * @author Ren Wanchun
 * @version 1.0
 */
class GetURL{
	public static void main(String[] args) {
		if(args.length<1){
			System.out.println("Usage: GetURL ");
		}
		else{
			getURL(args[0]);
		}	
	}

	/**
	 * This method will display the URL specified by the parameter
	 * @param u The URL to display
	 */
	protected static void getURL(String u){
		java.net.URL url;
		java.io.InputStream is;
		java.io.InputStreamReader isr;
		java.io.BufferedReader r;
		String str;

		try{
			System.out.println("Reading URL: "+u);
			url = new java.net.URL(u);
			is = url.openStream();
			isr = new java.io.InputStreamReader(is);
			r = new java.io.BufferedReader(isr);
			do{
				str = r.readLine();
				if(str != null){
					System.out.println(str);
				}
			}while(str!=null);
		}
		catch(java.net.MalformedURLException e){
			System.out.println("Must enter a valid URL");
		}
		catch (java.io.IOException e) {
			System.out.println("Can't connect");
		}
	}
} 