package com.racer.di.service.impl;

import com.racer.di.dao.PersonDao;
import com.racer.di.diimpl.RacerResource;
import com.racer.di.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service("personService") @Scope("singleton")
public class PersonServiceBean implements PersonService {
	/* (non-Javadoc)
	 * @see com.racer.springtest.service.impl.PersonService#save()
	 */
	//@Autowired @Qualifier("personDaoxxx")
	//@Autowired(required=true)

	private PersonDao personDao;
	public PersonServiceBean(PersonDao personDao, String name) {
		this.personDao = personDao;
		this.name = name;
	}
	private String name;
	private Integer id;
	private Set<String> sets=new HashSet<String>();
	private List<String> lists=new ArrayList<String>();
	private Properties properties=new Properties();
	private Map<String,String> maps=new HashMap<String,String>();
	public Map<String, String> getMaps() {
		return maps;
	}
	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}
	public PersonDao getPersonDao() {
		return personDao;
	}
	
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
	
	@PostConstruct
	public void init(){
		System.out.println(" 初始化");
	}
	public PersonServiceBean(){
		System.out.println("我被实例化了");
	}
	@Override
	public void save(){
		System.out.println("我是save()方法");
		personDao.add();
	}
	@PreDestroy
	public void destroy(){
		System.out.println("关闭打开的资源");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Set<String> getSets() {
		return sets;
	}
	public void setSets(Set<String> sets) {
		this.sets = sets;
	}
	public List<String> getLists() {
		return lists;
	}
	public void setLists(List<String> lists) {
		this.lists = lists;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

}
