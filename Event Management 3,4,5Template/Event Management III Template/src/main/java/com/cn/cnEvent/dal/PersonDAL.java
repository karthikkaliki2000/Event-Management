package com.cn.cnEvent.dal;

import java.util.List;

import com.cn.cnEvent.entity.Person;

public interface PersonDAL {

	Person getById(long id);

	List<Person> getAll();

}
