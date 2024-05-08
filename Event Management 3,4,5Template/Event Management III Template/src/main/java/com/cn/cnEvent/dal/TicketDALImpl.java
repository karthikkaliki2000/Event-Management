package com.cn.cnEvent.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnEvent.entity.Ticket;

@Repository
public class TicketDALImpl implements TicketDAL {

	@Autowired
	EntityManager entityManager;

	
	@Override
	public Ticket getById(long id) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		Ticket ticket=session.get(Ticket.class, id);
		return ticket;
	}

	@Override
	public List<Ticket> getAll() {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		List<Ticket> ticketsList=session.createQuery("Select t from Ticket t",Ticket.class).getResultList();
		return ticketsList;
	}

	@Override
	public List<Ticket> getAllByAge(long age) {
		// TODO Auto-generated method stub
		
		List<Ticket> ticketsListByAge=new ArrayList<Ticket>();
		List<Ticket> ticketsList=getAll();
		for(Ticket t:ticketsList) {
			if(t.getPerson().getAge()<age) {
				ticketsListByAge.add(t);
			}
		}
		return ticketsListByAge;
		
	}
	
	
}
