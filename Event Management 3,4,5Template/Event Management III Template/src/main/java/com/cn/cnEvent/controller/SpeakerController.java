package com.cn.cnEvent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.cnEvent.entity.Speaker;
import com.cn.cnEvent.service.SpeakerService;

@RestController
@RequestMapping("/speaker")
public class SpeakerController {

	@Autowired
	SpeakerService speakerService;
	
	@GetMapping("/{id}")
	public Speaker getById(@PathVariable long id){
		return speakerService.getById(id);
	}
	
	@GetMapping("/all")
	public List<Speaker> getAll(){
		return speakerService.getAll();
	}
	
	@GetMapping("/eventCount/{eventCount}/experience/{experience}")
	public List<Speaker> getAllSpeakers(@PathVariable long eventCount, @PathVariable long experience){
		return speakerService.getAllSpeakers(eventCount,experience);
	}
	
	@PostMapping("id/{speakerId}/eventId/{eventId}")
	public void saveSpeakerWithDetails(@PathVariable long eventId,@PathVariable long speakerId) {
		speakerService.saveSpeakerWithDetails(eventId,speakerId);
	}
	
	
	@PostMapping("/save")
	public String saveSpeaker(@RequestBody Speaker speaker) {
		return speakerService.saveSpeaker(speaker);
	}
}
