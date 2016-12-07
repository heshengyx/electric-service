package com.grgbanking.electric.dao;

import java.util.List;

import com.grgbanking.electric.entity.Event;
import com.grgbanking.electric.param.EventQueryParam;


public interface IEventDao {

    /**
     * 新增
     * @param event
     * @return
     */
    int save(Event event);
    /**
     * 批量新增
     * @param events
     * @return
     */
    int saveBatch(List<Event> events);
    
    /**
     * 修改
     * @param event
     */
    int update(Event event);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(String id);
    
    /**
     * 多条件删除
     * @param event
     */
    int delete(Event event);
    
    /**
     * 根据ID批量删除
     * @param id
     */
    int deleteByIds(List<String> ids);
    
    /**
     * 根据ID查找
     * @param id
     * @return
     */
    Event getById(String id);
    
    /**
     * 多条件查找
     * @param event
     * @return
     */
    Event getData(Event event);

    int count(EventQueryParam param);
    /**
     * 查询分页
     * @param param
     * @param start
     * @param end
     * @return
     */
    List<Event> query(EventQueryParam param, int start, int end);
    
    /**
     * 查询全部
     * @param param
     * @return
     */
    List<Event> queryAll(EventQueryParam param);
}
