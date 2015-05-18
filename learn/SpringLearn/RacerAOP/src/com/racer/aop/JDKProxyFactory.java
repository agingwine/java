package com.racer.aop;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.racer.service.impl.PersonServiceBean;

public class JDKProxyFactory implements InvocationHandler {
	private Object targetObject;
	public Object createProxyInstance(Object targetObject){
		this.targetObject=targetObject;
		return Proxy.newProxyInstance(this.targetObject.getClass().getClassLoader(), this.targetObject.getClass().getInterfaces(), this);
	}
	
	public Object invoke(Object proxy,Method method,Object[] args)throws Throwable{
		PersonServiceBean bean=(PersonServiceBean)this.targetObject;
		Object result=null;
		if(bean.getUser()!=null){
			result = method.invoke(targetObject, args);
		}
		return result;
	}
}
