package com.grgbanking.electric.dao;

import java.util.List;

import com.grgbanking.electric.entity.FreezeMonth;
import com.grgbanking.electric.param.FreezeMonthQueryParam;


public interface IFreezeMonthDao {

    /**
     * 新增
     * @param freezeMonth
     * @return
     */
    int save(FreezeMonth freezeMonth);
    /**
     * 批量新增
     * @param freezeMonths
     * @return
     */
    int saveBatch(List<FreezeMonth> freezeMonths);
    
    /**
     * 修改
     * @param freezeMonth
     */
    int update(FreezeMonth freezeMonth);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(String id);
    
    /**
     * 多条件删除
     * @param freezeMonth
     */
    int delete(FreezeMonth freezeMonth);
    
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
    FreezeMonth getById(String id);
    
    /**
     * 多条件查找
     * @param freezeMonth
     * @return
     */
    FreezeMonth getData(FreezeMonth freezeMonth);

    int count(FreezeMonthQueryParam param);
    /**
     * 查询分页
     * @param param
     * @param start
     * @param end
     * @return
     */
    List<FreezeMonth> query(FreezeMonthQueryParam param, int start, int end);
    
    /**
     * 查询全部
     * @param param
     * @return
     */
    List<FreezeMonth> queryAll(FreezeMonthQueryParam param);
}
