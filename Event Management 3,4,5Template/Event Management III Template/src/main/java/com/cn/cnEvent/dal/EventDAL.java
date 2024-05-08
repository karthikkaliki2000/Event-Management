package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.entity.Ticket;

import java.util.List;

public interface EventDAL {

	Event getById(Long id);

	List<Event> getAllEvents();

	EventScheduleDetail getEventScheduleDetailByEventId(Long id);

	List<Event> getAllEventsByLocation(String location);

	String save(Event item);

	String delete(Long id);

	String deleteEventScheduleDetail(Long id);

	String update(Event updateEvent);

	List<Ticket> getAllTicketsByEventId(long eventId);

	List<Event> getAllEventsPriceGreater(long price);
}
