package com.cn.cnEvent.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.Speaker;

@Repository
public class SpeakerDALImpl implements SpeakerDAL {

	@Autowired
	EntityManager entityManager;

	@Autowired
	EventDAL eventDAL;
	
	@Override
	public Speaker getById(long id) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		Speaker s=session.get(Speaker.class, id);
		return s;
	}

	@Override
	public List<Speaker> getAll() {
		Session session=entityManager.unwrap(Session.class);
		List<Speaker> sList=session.createQuery("Select s from Speaker s", Speaker.class).getResultList();
		return sList;
	}

	@Override
	public List<Speaker> getAllSpeakers(long eventCount, long experience) {
		List<Speaker> sList=getAll();
		List<Speaker> sListres=new ArrayList<Speaker>();
		for(Speaker s:sList) {
			if(s.getEvents().size()>=eventCount && s.getExperience()>experience) {
				sListres.add(s);
			}
		}
		return sListres;
	}

	@Override
	public void saveWithDetails(long eventId, long speakerId) {
		
		Session session=entityManager.unwrap(Session.class);
		Speaker s=new Speaker();
		List<Event> es=new ArrayList<Event>();
		es.add(eventDAL.getById(eventId));
		
		s.setEvents(es);
		s.setExperience(getById(speakerId).getExperience());
		s.setName(getById(speakerId).getName());
		session.save(s);
		
		
		
	}

	@Override
	public String save(Speaker speaker) {
		Session session=entityManager.unwrap(Session.class);
		session.save(speaker);
		return "The speaker was saved successfully.";
	}
	
	
	
}
