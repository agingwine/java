package com.racer.service;

public interface PersonService {
	public void save(String name);
	public void update(String name,Integer personId);
	public String getPersonName(Integer personId);
}
