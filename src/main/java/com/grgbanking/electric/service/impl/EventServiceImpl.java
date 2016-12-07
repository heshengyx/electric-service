package com.grgbanking.electric.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.grgbanking.electric.dao.IEventDao;
import com.grgbanking.electric.data.EventData;
import com.grgbanking.electric.entity.Event;
import com.grgbanking.electric.page.IPage;
import com.grgbanking.electric.page.IPagination;
import com.grgbanking.electric.page.Pager;
import com.grgbanking.electric.param.EventQueryParam;
import com.grgbanking.electric.service.IEventService;
import com.grgbanking.electric.util.UUIDGeneratorUtil;


@Service("eventService")
public class EventServiceImpl implements IEventService {

    @Autowired
    private IEventDao eventDao;
    
    @Override
    public void save(Event event) {
        String name = event.getName();
if (StringUtils.isEmpty(name)) {
throw new DataAccessResourceFailureException("采样时间不能为空");
}

        event.setId(UUIDGeneratorUtil.getUUID());
        event.setCreateTime(new Date());
        
        int count = eventDao.save(event);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据保存失败");
        }
    }

    @Override
    public void saveBatch(List<Event> events) {
        Event event = null;
        for (int i = 0; i < events.size(); i++) {
            event = events.get(i);
            event.setId(UUIDGeneratorUtil.getUUID());
            event.setCreateTime(new Date());
            events.set(i, event);
        }
        int count = eventDao.saveBatch(events);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据保存失败");
        }
    }
    
    @Override
    public void saveBatchData(EventData data) {
                //
    }
    
    @Override
    public void update(Event event) {
        String name = event.getName();
if (StringUtils.isEmpty(name)) {
throw new DataAccessResourceFailureException("采样时间不能为空");
}

        event.setUpdateTime(new Date());
        int count = eventDao.update(event);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据修改失败");
        }
    }

    @Override
    public void deleteById(String id) {
        if (!StringUtils.isEmpty(id)) {
            int count = eventDao.deleteById(id);
            if (count == 0) {
                throw new DataAccessResourceFailureException("数据删除失败");
            }
        } else {
            throw new DataAccessResourceFailureException("数据删除失败");
        }
    }
    
    @Override
    public void deleteByIds(List<String> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            int count = eventDao.deleteByIds(ids);
            if (count == 0) {
                throw new DataAccessResourceFailureException("数据删除失败");
            }
        } else {
            throw new DataAccessResourceFailureException("数据删除失败");
        }
    }

    @Override
    public void delete(Event event) {
        int count = eventDao.delete(event);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据删除失败");
        }
    }

    @Override
    public Event getById(String id) {
        return eventDao.getById(id);
    }

    @Override
    public Event getData(Event event) {
        return eventDao.getData(event);
    }
    
    @Override
    public void saveOrUpdate(Event event) {
        if (StringUtils.isEmpty(event.getId())) {
            save(event);
        } else {
            update(event);
        }
    }

    @Override
    public IPage<Event> query(final EventQueryParam param) {
        int page = param.getPage() <= 0 ? 1 : param.getPage();
        int rows = param.getRows() <= 0 ? 10 : param.getRows();
        return Pager.execute(new IPagination<Event>() {

            @Override
            public int count() {
                return eventDao.count(param);
            }

            @Override
            public List<Event> query(int start, int end) {
                return eventDao.query(param, start, end);
            }
        }, page, rows);
    }
    
    @Override
	public List<Event> queryAll(EventQueryParam param) {
		return eventDao.queryAll(param);
	}
}