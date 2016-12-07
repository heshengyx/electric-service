package com.grgbanking.electric.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.electric.dao.IEventDao;
import com.grgbanking.electric.entity.Event;
import com.grgbanking.electric.mapper.IEventMapper;
import com.grgbanking.electric.param.EventQueryParam;


@Repository
public class EventDaoImpl implements IEventDao {

    @Autowired
    private IEventMapper eventMapper;
    
    @Override
    public int save(Event event) {
        return eventMapper.save(event);
    }

    @Override
    public int saveBatch(List<Event> events) {
        return eventMapper.saveBatch(events);
    }
    
    @Override
    public int update(Event event) {
        return eventMapper.update(event);
    }

    @Override
    public int deleteById(String id) {
        return eventMapper.deleteById(id);
    }

    @Override
    public int delete(Event event) {
        return eventMapper.delete(event);
    }
    
    @Override
    public int deleteByIds(List<String> ids) {
        return eventMapper.deleteByIds(ids);
    }

    @Override
    public Event getById(String id) {
        return eventMapper.getById(id);
    }

    @Override
    public Event getData(Event event) {
        return eventMapper.getData(event);
    }

    @Override
    public int count(EventQueryParam param) {
        return eventMapper.count(param);
    }

    @Override
    public List<Event> query(EventQueryParam param, int start,
            int end) {
        return eventMapper.query(param, start, end);
    }

    @Override
    public List<Event> queryAll(EventQueryParam param) {
        return eventMapper.queryAll(param);
    }
}
