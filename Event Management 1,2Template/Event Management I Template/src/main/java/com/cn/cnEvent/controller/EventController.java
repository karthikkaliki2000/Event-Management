package com.cn.cnEvent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	EventService eventService;
	
	@GetMapping("/{id}")
	public Event getEventById(@PathVariable long id) {
		return eventService.getEventById(id);
	}
	
	@GetMapping("/all")
	public List<Event> getall(){

		return eventService.getAll();
	}
	
	
	@PostMapping("/save")
	public String saveEvent(@RequestBody Event event) {
		
		return eventService.saveEvent(event);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteEvent(@PathVariable long id) {
		return eventService.deleteEvent(id);
	}
	
	@PutMapping("/update")
	public String updateEvent(@RequestBody Event event) {
		return eventService.updateEvent(event);
	}
	
	
}
