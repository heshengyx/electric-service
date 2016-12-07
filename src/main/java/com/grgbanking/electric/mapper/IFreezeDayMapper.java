package com.grgbanking.electric.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.grgbanking.electric.entity.FreezeDay;
import com.grgbanking.electric.param.FreezeDayQueryParam;


public interface IFreezeDayMapper {

    /**
     * 新增
     * @param freezeDay
     * @return
     */
    int save(@Param("param") FreezeDay freezeDay);
    /**
     * 批量新增
     * @param freezeDays
     * @return
     */
    int saveBatch(@Param("list") List<FreezeDay> freezeDays);
    
    /**
     * 修改
     * @param freezeDay
     */
    int update(@Param("param") FreezeDay freezeDay);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(@Param("id") String id);
    
    /**
     * 多条件删除
     * @param freezeDay
     */
    int delete(@Param("param") FreezeDay freezeDay);
    
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
    FreezeDay getById(@Param("id") String id);
    
    /**
     * 多条件查找
     * @param freezeDay
     * @return
     */
    FreezeDay getData(@Param("param") FreezeDay freezeDay);
    
    int count(@Param("param") FreezeDayQueryParam param);
    List<FreezeDay> query(@Param("param") FreezeDayQueryParam param,
            @Param("start") int start, @Param("end") int end);
    
    /**
     * 查找全部
     * @param param
     * @return
     */
    List<FreezeDay> queryAll(@Param("param") FreezeDayQueryParam param);
}

