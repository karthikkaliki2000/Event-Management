package com.cn.cnEvent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.cnEvent.entity.Person;
import com.cn.cnEvent.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService personService;
	
	@GetMapping("/{id}")
	public Person getById(@PathVariable long id) {
		return personService.getById(id);
	}
	
	@GetMapping("/all")
	public List<Person> getAll(){
		return personService.getAll();
	}
}
