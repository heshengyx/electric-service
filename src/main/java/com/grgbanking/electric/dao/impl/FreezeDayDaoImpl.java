package com.grgbanking.electric.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.electric.dao.IFreezeDayDao;
import com.grgbanking.electric.entity.FreezeDay;
import com.grgbanking.electric.mapper.IFreezeDayMapper;
import com.grgbanking.electric.param.FreezeDayQueryParam;


@Repository
public class FreezeDayDaoImpl implements IFreezeDayDao {

    @Autowired
    private IFreezeDayMapper freezeDayMapper;
    
    @Override
    public int save(FreezeDay freezeDay) {
        return freezeDayMapper.save(freezeDay);
    }

    @Override
    public int saveBatch(List<FreezeDay> freezeDays) {
        return freezeDayMapper.saveBatch(freezeDays);
    }
    
    @Override
    public int update(FreezeDay freezeDay) {
        return freezeDayMapper.update(freezeDay);
    }

    @Override
    public int deleteById(String id) {
        return freezeDayMapper.deleteById(id);
    }

    @Override
    public int delete(FreezeDay freezeDay) {
        return freezeDayMapper.delete(freezeDay);
    }
    
    @Override
    public int deleteByIds(List<String> ids) {
        return freezeDayMapper.deleteByIds(ids);
    }

    @Override
    public FreezeDay getById(String id) {
        return freezeDayMapper.getById(id);
    }

    @Override
    public FreezeDay getData(FreezeDay freezeDay) {
        return freezeDayMapper.getData(freezeDay);
    }

    @Override
    public int count(FreezeDayQueryParam param) {
        return freezeDayMapper.count(param);
    }

    @Override
    public List<FreezeDay> query(FreezeDayQueryParam param, int start,
            int end) {
        return freezeDayMapper.query(param, start, end);
    }

    @Override
    public List<FreezeDay> queryAll(FreezeDayQueryParam param) {
        return freezeDayMapper.queryAll(param);
    }
}
