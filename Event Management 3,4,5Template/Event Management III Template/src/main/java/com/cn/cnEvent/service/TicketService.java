package com.cn.cnEvent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnEvent.dal.TicketDAL;
import com.cn.cnEvent.entity.Ticket;
import com.cn.cnEvent.exception.InvalidInputException;
import com.cn.cnEvent.exception.NotFoundException;

@Service
public class TicketService {

	@Autowired
	TicketDAL ticketDAL;
	
	@Transactional
	public Ticket getById(long id) {
		// TODO Auto-generated method stub
		Ticket ticket=ticketDAL.getById(id);
		if(ticket==null) {
			throw new NotFoundException("not found");
		}
		return ticket;
	}

	@Transactional
	public List<Ticket> getAll() {
		// TODO Auto-generated method stub
		List<Ticket> ticketsList=ticketDAL.getAll();
		if(ticketsList==null) {
			throw new NotFoundException("not found");
		}
		return ticketsList;
	}

	@Transactional
	public List<Ticket> getAllByAge(long age) {
		// TODO Auto-generated method stub
		List<Ticket> ticketsList=ticketDAL.getAllByAge(age);
		if(ticketsList==null) {
			throw new NotFoundException("not found");
		}
		return ticketsList;
	}

}
