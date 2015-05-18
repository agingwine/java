package com.racer.aop;

import java.lang.reflect.Method;

import com.racer.service.impl.PersonServiceBean;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


public class CGlibProxyFactory implements MethodInterceptor {
	private Object targetObject;
	public Object createProxyInstance(Object targetObject){
		this.targetObject=targetObject;
		Enhancer enhancer=new Enhancer();
		enhancer.setSuperclass(this.targetObject.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	public Object intercept(Object proxy,Method method,Object[] args,MethodProxy methodProxy)throws Throwable{
		PersonServiceBean bean=(PersonServiceBean)this.targetObject;
		Object result=null;
		if(bean.getUser()!=null){
			result = method.invoke(targetObject, args);
		}
		return result;
	}
}
