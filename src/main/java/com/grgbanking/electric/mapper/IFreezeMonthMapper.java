package com.grgbanking.electric.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.grgbanking.electric.entity.FreezeMonth;
import com.grgbanking.electric.param.FreezeMonthQueryParam;


public interface IFreezeMonthMapper {

    /**
     * 新增
     * @param freezeMonth
     * @return
     */
    int save(@Param("param") FreezeMonth freezeMonth);
    /**
     * 批量新增
     * @param freezeMonths
     * @return
     */
    int saveBatch(@Param("list") List<FreezeMonth> freezeMonths);
    
    /**
     * 修改
     * @param freezeMonth
     */
    int update(@Param("param") FreezeMonth freezeMonth);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(@Param("id") String id);
    
    /**
     * 多条件删除
     * @param freezeMonth
     */
    int delete(@Param("param") FreezeMonth freezeMonth);
    
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
    FreezeMonth getById(@Param("id") String id);
    
    /**
     * 多条件查找
     * @param freezeMonth
     * @return
     */
    FreezeMonth getData(@Param("param") FreezeMonth freezeMonth);
    
    int count(@Param("param") FreezeMonthQueryParam param);
    List<FreezeMonth> query(@Param("param") FreezeMonthQueryParam param,
            @Param("start") int start, @Param("end") int end);
    
    /**
     * 查找全部
     * @param param
     * @return
     */
    List<FreezeMonth> queryAll(@Param("param") FreezeMonthQueryParam param);
}

