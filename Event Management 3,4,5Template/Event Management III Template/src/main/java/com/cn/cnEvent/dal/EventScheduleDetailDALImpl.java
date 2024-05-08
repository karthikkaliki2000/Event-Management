package com.cn.cnEvent.dal;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnEvent.entity.EventScheduleDetail;

@Repository
public class EventScheduleDetailDALImpl implements EventScheduleDetailDAL{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public EventScheduleDetail getById(Long id) {
		
		Session session=entityManager.unwrap(Session.class);
		EventScheduleDetail eventScheduleDetails=session.get(EventScheduleDetail.class, id);
		return eventScheduleDetails;
	}

	@Override
	public String save(EventScheduleDetail eventScheduleDetail) {
		Session session = entityManager.unwrap(Session.class);
		session.save(eventScheduleDetail);
		return "The eventScheduleDetail was saved successfully.";
	}

	@Override
	public List<EventScheduleDetail> getAll() {
		Session session=entityManager.unwrap(Session.class);
		List<EventScheduleDetail> eventScheduleDetailsList=session.createQuery("Select e from EventScheduleDetail e", EventScheduleDetail.class).getResultList();
		return eventScheduleDetailsList;
	}

}
