package com.racer.aop.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.racer.aop.service.*;

@Service("personServiceBean" ) @Scope("prototype")
public class PersonServiceBean implements PersonService {
    private String name;
	public  PersonServiceBean(){}
	public void save(String name) {
		System.out.println("我是save()方法");
	}

	public void update(String name, Integer id) {
		System.out.println("我是update()方法");
	}

	public String getPersonName(Integer id) {
		return "xxx";
	}
	

}
