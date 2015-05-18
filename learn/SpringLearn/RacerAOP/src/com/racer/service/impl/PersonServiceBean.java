package com.racer.service.impl;

import com.racer.service.PersonService;

public class PersonServiceBean implements PersonService {
	private String user;
	public PersonServiceBean(){
		
	}
	public PersonServiceBean(String user){
		this.setUser(user);
	}
	@Override
	public void save(String name){
		System.out.println("我是save()方法");
	}
	@Override
	public void update(String name,Integer personId){
		System.out.println("我是update()方法");
	}
	@Override
	public String getPersonName(Integer personId){
		System.out.println("我是getPersonName()方法");
		return "xxx";
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
}
