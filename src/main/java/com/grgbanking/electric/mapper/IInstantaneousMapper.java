package com.grgbanking.electric.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.grgbanking.electric.entity.Instantaneous;
import com.grgbanking.electric.param.InstantaneousQueryParam;


public interface IInstantaneousMapper {

    /**
     * 新增
     * @param instantaneous
     * @return
     */
    int save(@Param("param") Instantaneous instantaneous);
    /**
     * 批量新增
     * @param instantaneouss
     * @return
     */
    int saveBatch(@Param("list") List<Instantaneous> instantaneouss);
    
    /**
     * 修改
     * @param instantaneous
     */
    int update(@Param("param") Instantaneous instantaneous);
    
    /**
     * 根据ID删除
     * @param id
     */
    int deleteById(@Param("id") String id);
    
    /**
     * 多条件删除
     * @param instantaneous
     */
    int delete(@Param("param") Instantaneous instantaneous);
    
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
    Instantaneous getById(@Param("id") String id);
    
    /**
     * 多条件查找
     * @param instantaneous
     * @return
     */
    Instantaneous getData(@Param("param") Instantaneous instantaneous);
    
    int count(@Param("param") InstantaneousQueryParam param);
    List<Instantaneous> query(@Param("param") InstantaneousQueryParam param,
            @Param("start") int start, @Param("end") int end);
    
    /**
     * 查找全部
     * @param param
     * @return
     */
    List<Instantaneous> queryAll(@Param("param") InstantaneousQueryParam param);
}

