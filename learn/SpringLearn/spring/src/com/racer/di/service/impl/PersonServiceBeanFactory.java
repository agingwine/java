package com.racer.di.service.impl;

public class PersonServiceBeanFactory {
	public static PersonServiceBean createPersonServiceBean(){
		return new PersonServiceBean();
	}
	
	public PersonServiceBean createPersonServiceBean2(){
		return new PersonServiceBean();
	}
}
