package com.grgbanking.electric.dao;

import java.util.List;

import com.grgbanking.electric.entity.Instantaneous;
import com.grgbanking.electric.param.InstantaneousQueryParam;


public interface IInstantaneousDao {

    /**
     * 新增
     * @param instantaneous
     * @return
     */
    int save(Instantaneous instantaneous);
    /**
     * 批量新增
     * @param instantaneouss
     * @return
     */
    int saveBatch(List<Instantaneous> instantaneouss);
    
    /**
     * 修改
     * @param instantaneous
     */
    int update(Instantaneous instantaneous);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(String id);
    
    /**
     * 多条件删除
     * @param instantaneous
     */
    int delete(Instantaneous instantaneous);
    
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
    Instantaneous getById(String id);
    
    /**
     * 多条件查找
     * @param instantaneous
     * @return
     */
    Instantaneous getData(Instantaneous instantaneous);

    int count(InstantaneousQueryParam param);
    /**
     * 查询分页
     * @param param
     * @param start
     * @param end
     * @return
     */
    List<Instantaneous> query(InstantaneousQueryParam param, int start, int end);
    
    /**
     * 查询全部
     * @param param
     * @return
     */
    List<Instantaneous> queryAll(InstantaneousQueryParam param);
}
