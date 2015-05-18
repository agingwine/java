package com.racer.searchengine.example;

import java.net.*;
/**
 * 查找域名的示例程序
 * 输入域名，返回对应的IP地址
 * @author Ren Wanchun
 * @version 1.0
*/

public class Lookup{
	public static void main(String[] args){
		try{
			if(0==args.length){
				System.out.println("Call with one parameter that specifies the host to lookup.");
			}
			else{
				InetAddress address=InetAddress.getByName(args[0]);
				System.out.println(address);
			}
		}
		catch(Exception e){
			System.out.println("Could not find "+args[0]);
		}
	}
}