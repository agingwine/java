package com.racer.di.diimpl;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.Element;
import org.dom4j.XPath;

import java.util.*;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

import org.apache.commons.beanutils.ConvertUtils;

/**
 *  简单Spring容器实现
 * @author vincent
 * @version v1.0
 */
public class RacerClassPathXmlApplicationContext {
	private List<BeanDefinition> beanDefines = new ArrayList<BeanDefinition>();
	private Map<String, Object> singletons = new HashMap<String, Object>();

	public RacerClassPathXmlApplicationContext(String filename) {
		this.readXML(filename);
		this.instanceBeans();
		this.annotationInject();
		this.insertObject();
	}
	
	/**
	 * 使用注解方式进行注解
	 */
	private void annotationInject(){
		for(String beanName:singletons.keySet()){
			Object bean = singletons.get(beanName);
			if(bean!=null){
				try {
					PropertyDescriptor[] ps= Introspector.getBeanInfo(bean.getClass()).getPropertyDescriptors();
					for(PropertyDescriptor propertyDesc:ps){
						Method setter=propertyDesc.getWriteMethod();//获取属性Property的写方法
						if(setter!=null && setter.isAnnotationPresent(RacerResource.class)){
							RacerResource resource = setter.getAnnotation(RacerResource.class);//获取写方法的注解
							Object value;
							if(resource.name()!=null&&!"".equals(resource.name())){
								value=singletons.get(resource.name());//1.使用注解的name属性查找bean
							}
							else{
								value=singletons.get(propertyDesc.getName());//2.使用属性property的名称查找bean
								if(value==null){
									for(String key:singletons.keySet()){
										if(propertyDesc.getPropertyType().isAssignableFrom(singletons.get(key).getClass())){
											value=singletons.get(key);//3.使用属性property的类型查找bean
											break;
										}
									}
								}
							}
							setter.setAccessible(true);//解决私有方法调用
							setter.invoke(bean, value);//调用写方法
						}
					}
					Field[] fields=bean.getClass().getDeclaredFields();
					for(Field field:fields){
						if(field.isAnnotationPresent(RacerResource.class)){
							RacerResource resource = field.getAnnotation(RacerResource.class);//获取字段的注解
							Object value;
							if(resource.name()!=null&&!"".equals(resource.name())){
								value=singletons.get(resource.name());//1.使用注解的name属性查找bean
							}
							else{
								value=singletons.get(field.getName());//2.使用属性property的名称查找bean
								if(value==null){
									for(String key:singletons.keySet()){
										if(field.getType().isAssignableFrom(singletons.get(key).getClass())){
											value=singletons.get(key);//3.使用属性property的类型查找bean
											break;
										}
									}
								}
							}
							field.setAccessible(true);
							field.set(bean, value);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 使用setter方法进行依赖对象注入(DI)
	 */
	private void insertObject() {
		for(BeanDefinition beanDefinition:beanDefines){
			Object bean=singletons.get(beanDefinition.getId());
			if(bean!=null){
				try {
					PropertyDescriptor[] ps= Introspector.getBeanInfo(bean.getClass()).getPropertyDescriptors();//类的属性数组
					for(PropertyDefinition propertyDefinition:beanDefinition.getPropertys()){
						for(PropertyDescriptor propertyDesc:ps){
							if(propertyDefinition.getName().equals(propertyDesc.getName())){
								Method setter=propertyDesc.getWriteMethod();//获取属性Property的写方法
								if(setter!=null){
									Object value;
									//若ref不为null并且ref的值不为空字符串
									if(propertyDefinition.getRef()!=null&&!"".equals( propertyDefinition.getRef().trim())){
										value=singletons.get(propertyDefinition.getRef());
									}
									else{
										value=ConvertUtils.convert(propertyDefinition.getValue(), propertyDesc.getPropertyType());
									}
									setter.setAccessible(true);//解决私有方法调用
									setter.invoke(bean, value);//调用写方法
								}
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
	}

	/**
	 * 实例化bean
	 */
	private void instanceBeans() {
		for (BeanDefinition beanDefinition : beanDefines) {
			try {
				if (beanDefinition.getClassName() != null
						&& !"".equals(beanDefinition.getClassName().trim())) {
					singletons.put(beanDefinition.getId(),Class.forName( beanDefinition.getClassName()).newInstance() );
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 读取XML配置文件
	 * @param filename 配置文件名称
	 */
	private void readXML(String filename) {
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			URL xmlPath = this.getClass().getClassLoader()
					.getResource(filename);
			document = saxReader.read(xmlPath);
			Map<String, String> nsMap = new HashMap<String, String>();
			nsMap.put("ns", "http://www.springframework.org/schema/beans");// 加入命名空间
			XPath xsub = document.createXPath("//ns:beans/ns:bean");// 创建beans/bean查询路径
			xsub.setNamespaceURIs(nsMap);// 设置命名空间
			List<Element> beans = xsub.selectNodes(document);
			//读取bean元素的属性
			for (Element element : beans) {
				String id = element.attributeValue("id");
				String className = element.attributeValue("class");
				BeanDefinition beanDefine = new BeanDefinition(id, className);
				XPath propertySub=element.createXPath("ns:property");
				propertySub.setNamespaceURIs(nsMap);
				List<Element> propertys=propertySub.selectNodes(element);
				for(Element property : propertys){
					String propertyName=property.attributeValue("name");
					String propertyRef=property.attributeValue("ref");
					String propertyValue=property.attributeValue("value");
					System.out.println(propertyName+"="+propertyRef);
					
					PropertyDefinition propertyDefine=new PropertyDefinition(propertyName,propertyRef,propertyValue);
					beanDefine.getPropertys().add(propertyDefine);
				}
				beanDefines.add(beanDefine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  获取bean实例
	 */
	public Object getBean(String beanName){
		return this.singletons.get(beanName);
	}
}
