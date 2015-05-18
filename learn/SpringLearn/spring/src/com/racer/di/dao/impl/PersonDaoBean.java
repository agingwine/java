package com.racer.di.dao.impl;

import org.springframework.stereotype.Repository;

import com.racer.di.dao.PersonDao;

@Repository
public class PersonDaoBean implements PersonDao {
	/* (non-Javadoc)
	 * @see com.racer.springtest.dao.impl.PersonDao#add()
	 */
	@Override
	public void add(){
		System.out.println("执行PersonDaoBean中的add()方法");
	}
}
