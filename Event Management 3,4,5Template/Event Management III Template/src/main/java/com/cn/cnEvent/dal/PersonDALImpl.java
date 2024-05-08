package com.cn.cnEvent.dal;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cn.cnEvent.entity.Person;

@Repository
public class PersonDALImpl implements PersonDAL {

	@Autowired
	EntityManager entityManager;

	@Override
	public Person getById(long id) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		Person p=session.get(Person.class, id);
		return p;
	}

	@Override
	public List<Person> getAll() {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		List<Person> ps=session.createQuery("Select p from Person p",Person.class).getResultList();
		return ps;
	}
	
	
}
