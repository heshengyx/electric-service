package com.grgbanking.electric.dao;

import java.util.List;

import com.grgbanking.electric.entity.FreezeDay;
import com.grgbanking.electric.param.FreezeDayQueryParam;


public interface IFreezeDayDao {

    /**
     * 新增
     * @param freezeDay
     * @return
     */
    int save(FreezeDay freezeDay);
    /**
     * 批量新增
     * @param freezeDays
     * @return
     */
    int saveBatch(List<FreezeDay> freezeDays);
    
    /**
     * 修改
     * @param freezeDay
     */
    int update(FreezeDay freezeDay);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(String id);
    
    /**
     * 多条件删除
     * @param freezeDay
     */
    int delete(FreezeDay freezeDay);
    
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
    FreezeDay getById(String id);
    
    /**
     * 多条件查找
     * @param freezeDay
     * @return
     */
    FreezeDay getData(FreezeDay freezeDay);

    int count(FreezeDayQueryParam param);
    /**
     * 查询分页
     * @param param
     * @param start
     * @param end
     * @return
     */
    List<FreezeDay> query(FreezeDayQueryParam param, int start, int end);
    
    /**
     * 查询全部
     * @param param
     * @return
     */
    List<FreezeDay> queryAll(FreezeDayQueryParam param);
}
