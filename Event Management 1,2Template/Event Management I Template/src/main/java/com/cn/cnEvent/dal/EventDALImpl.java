package com.cn.cnEvent.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnEvent.entity.Event;

@Repository
@Transactional
public class EventDALImpl implements EventDAL {
	
	@Autowired
	EntityManager entityManager;
	
	@Override
	public Event getById(Long id) {
		
		Session session=entityManager.unwrap(Session.class);
		Event event=session.get(Event.class, id);
		return event;
	}

	@Override
	public List<Event> getAllEvents() {
		Session session=entityManager.unwrap(Session.class);
		
		List<Event> Allevents=session.createQuery("select p from Event p", Event.class).getResultList();
		
		return Allevents;
	}

	@Override
	public String save(Event item) {
		Session session=entityManager.unwrap(Session.class);
		session.save(item);
		return "The event was saved successfully.";
	}

	@Override
	public String delete(long id) {
		Session session=entityManager.unwrap(Session.class);
		Event event=session.get(Event.class, id);
		session.delete(event);
		return "The event was deleted successfully";
	}

	@Override
	public String update(Event event) {
		Session session=entityManager.unwrap(Session.class);
		Event currevent=session.get(Event.class, event.getId());
		currevent.setDescription(event.getDescription());
		currevent.setName(event.getName());
		session.update(currevent);
		return "Event is updated successfully";
	}

}
