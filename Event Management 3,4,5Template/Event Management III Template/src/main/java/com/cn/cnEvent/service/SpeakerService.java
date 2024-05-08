package com.cn.cnEvent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnEvent.dal.SpeakerDAL;
import com.cn.cnEvent.entity.Speaker;
import com.cn.cnEvent.exception.ElementAlreadyExistException;
import com.cn.cnEvent.exception.NotFoundException;

@Service
public class SpeakerService {

	@Autowired
	SpeakerDAL speakerDAL;
	
	@Transactional
	public Speaker getById(long id) {
		// TODO Auto-generated method stub
		Speaker speaker=speakerDAL.getById(id);
		if(speaker==null) {
			throw new NotFoundException("id not exist");
		}
		return speaker;
	}

	@Transactional
	public List<Speaker> getAll() {
		List<Speaker> speakers=speakerDAL.getAll();
		if(speakers==null) {
			throw new NotFoundException("id not exist");
		}
		return speakers;
	}

	@Transactional
	public List<Speaker> getAllSpeakers(long eventCount, long experience) {
		List<Speaker> speakers=speakerDAL.getAllSpeakers(eventCount,experience);
		if(speakers==null) {
			throw new NotFoundException("id not exist");
		}
		return speakers;
	}

	@Transactional
	public void saveSpeakerWithDetails(long eventId, long speakerId) {
		
		speakerDAL.saveWithDetails(eventId,speakerId);
		
	}

	@Transactional
	public String saveSpeaker(Speaker speaker) {
		
		try {
			return speakerDAL.save(speaker);
		} catch (Exception e) {
			throw new ElementAlreadyExistException("already exist");
		}
		
	
		
	}

}
