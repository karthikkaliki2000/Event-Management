package com.cn.cnEvent.dal;

import java.util.List;

import com.cn.cnEvent.entity.EventScheduleDetail;

public interface EventScheduleDetailDAL {

	EventScheduleDetail getById(Long id);

	String save(EventScheduleDetail eventScheduleDetails);

	List<EventScheduleDetail> getAll();

}
