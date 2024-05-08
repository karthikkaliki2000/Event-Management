package com.cn.cnEvent.dal;

import java.util.List;

import com.cn.cnEvent.entity.Speaker;

public interface SpeakerDAL {

	Speaker getById(long id);

	List<Speaker> getAll();

	List<Speaker> getAllSpeakers(long eventCount, long experience);

	void saveWithDetails(long eventId, long speakerId);

	String save(Speaker speaker);

}
