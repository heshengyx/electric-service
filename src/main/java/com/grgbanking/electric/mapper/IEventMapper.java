package com.grgbanking.electric.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.grgbanking.electric.entity.Event;
import com.grgbanking.electric.param.EventQueryParam;


public interface IEventMapper {

    /**
     * 新增
     * @param event
     * @return
     */
    int save(@Param("param") Event event);
    /**
     * 批量新增
     * @param events
     * @return
     */
    int saveBatch(@Param("list") List<Event> events);
    
    /**
     * 修改
     * @param event
     */
    int update(@Param("param") Event event);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(@Param("id") String id);
    
    /**
     * 多条件删除
     * @param event
     */
    int delete(@Param("param") Event event);
    
    /**
     * 根据ID批量删除
     * @param id
     */
    int deleteByIds(@Param("ids") List<String> ids);
    
    /**
     * 根据ID查找
     * @param id
     * @return
     */
    Event getById(@Param("id") String id);
    
    /**
     * 多条件查找
     * @param event
     * @return
     */
    Event getData(@Param("param") Event event);
    
    int count(@Param("param") EventQueryParam param);
    List<Event> query(@Param("param") EventQueryParam param,
            @Param("start") int start, @Param("end") int end);
    
    /**
     * 查找全部
     * @param param
     * @return
     */
    List<Event> queryAll(@Param("param") EventQueryParam param);
}

