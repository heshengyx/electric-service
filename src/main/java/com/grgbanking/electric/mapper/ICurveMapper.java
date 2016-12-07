package com.grgbanking.electric.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.grgbanking.electric.entity.Curve;
import com.grgbanking.electric.param.CurveQueryParam;


public interface ICurveMapper {

    /**
     * 新增
     * @param curve
     * @return
     */
    int save(@Param("param") Curve curve);
    /**
     * 批量新增
     * @param curves
     * @return
     */
    int saveBatch(@Param("list") List<Curve> curves);
    
    /**
     * 修改
     * @param curve
     */
    int update(@Param("param") Curve curve);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(@Param("id") String id);
    
    /**
     * 多条件删除
     * @param curve
     */
    int delete(@Param("param") Curve curve);
    
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
    Curve getById(@Param("id") String id);
    
    /**
     * 多条件查找
     * @param curve
     * @return
     */
    Curve getData(@Param("param") Curve curve);
    
    int count(@Param("param") CurveQueryParam param);
    List<Curve> query(@Param("param") CurveQueryParam param,
            @Param("start") int start, @Param("end") int end);
    
    /**
     * 查找全部
     * @param param
     * @return
     */
    List<Curve> queryAll(@Param("param") CurveQueryParam param);
}

