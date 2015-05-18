package com.racer.searchengine.example;

import java.net.*;
import java.io.*;

/**
 * 一个简单的Web服务器示例，不论任何请求都返回一个简单的网页
 * @author Ren Wanchun
 * @version 1.0
 */

public class WebServer{
	/**
	 * WebServer Constructor
	 */
	protected void start(){
		java.net.ServerSocket serverSocket;
		System.out.println("WebServer starting up on port 8989...");
		System.out.println("Press Ctrl-C to exit...");
		try{
			serverSocket = new ServerSocket(8989);
		}catch(Exception e){
			System.out.println("Error: "+e);
			return;
		}

		System.out.println("Wating for connection...");
		while(true){
			try{
				java.net.Socket remoteSocket = serverSocket.accept();
				System.out.println("Connection, sending data...");
				java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(remoteSocket.getInputStream()));
				java.io.PrintWriter out = new java.io.PrintWriter(remoteSocket.getOutputStream());

				String str=".";
				while(!str.equals("")){
					str=in.readLine();
					System.out.println("Receive:"+str);
				}

				out.println("HTTP/1.0 200 OK");
				out.println("Content-Type:text/html");
				out.println("Server:Bot");
				//空行结束头部
				out.println("");
				out.println("<h1>Welcome to the Ultra Mini-WebServer.</h1>");
				out.flush();
				remoteSocket.close();
			}
			catch(Exception e){
				System.out.println("Error: "+e);
			}
		}
	}
	/**
	 * main 函数
	 */
	public static void main(String[] args){
		WebServer ws = new WebServer();
		ws.start();
	}
}