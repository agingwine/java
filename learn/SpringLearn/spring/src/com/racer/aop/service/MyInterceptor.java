package com.racer.aop.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect @Component
public class MyInterceptor {
	@Pointcut("execution (* com.racer.aop.service.impl.PersonServiceBean.*(..))")
	private void anyMethod(){}
	
	@Before("anyMethod()")
	public void doAccessCheck(){
		System.out.println("前置通知");
	}
}
