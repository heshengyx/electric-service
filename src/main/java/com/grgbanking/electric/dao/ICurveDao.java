package com.grgbanking.electric.dao;

import java.util.List;

import com.grgbanking.electric.entity.Curve;
import com.grgbanking.electric.param.CurveQueryParam;


public interface ICurveDao {

    /**
     * 新增
     * @param curve
     * @return
     */
    int save(Curve curve);
    /**
     * 批量新增
     * @param curves
     * @return
     */
    int saveBatch(List<Curve> curves);
    
    /**
     * 修改
     * @param curve
     */
    int update(Curve curve);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(String id);
    
    /**
     * 多条件删除
     * @param curve
     */
    int delete(Curve curve);
    
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
    Curve getById(String id);
    
    /**
     * 多条件查找
     * @param curve
     * @return
     */
    Curve getData(Curve curve);

    int count(CurveQueryParam param);
    /**
     * 查询分页
     * @param param
     * @param start
     * @param end
     * @return
     */
    List<Curve> query(CurveQueryParam param, int start, int end);
    
    /**
     * 查询全部
     * @param param
     * @return
     */
    List<Curve> queryAll(CurveQueryParam param);
}
