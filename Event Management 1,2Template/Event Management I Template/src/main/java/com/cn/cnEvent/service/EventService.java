package com.cn.cnEvent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnEvent.dal.EventDAL;
import com.cn.cnEvent.entity.Event;

@Service
public class EventService {

	@Autowired
	EventDAL eventDAL;
	
	

	@Transactional
	public List<Event> getAll() {
		// TODO Auto-generated method stub
		return eventDAL.getAllEvents();
	}

	@Transactional
	public String saveEvent(Event event) {
		// TODO Auto-generated method stub
		return eventDAL.save(event);
	}

	@Transactional
	public Event getEventById(long id) {
		// TODO Auto-generated method stub
		return eventDAL.getById(id);
	}

	@Transactional
	public String deleteEvent(long id) {
		// TODO Auto-generated method stub
		return eventDAL.delete(id);
	}

	@Transactional
	public String updateEvent(Event event) {
		// TODO Auto-generated method stub
		return eventDAL.update(event);
	}

	

}
