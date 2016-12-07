package com.grgbanking.electric.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.electric.dao.IFreezeMonthDao;
import com.grgbanking.electric.entity.FreezeMonth;
import com.grgbanking.electric.mapper.IFreezeMonthMapper;
import com.grgbanking.electric.param.FreezeMonthQueryParam;


@Repository
public class FreezeMonthDaoImpl implements IFreezeMonthDao {

    @Autowired
    private IFreezeMonthMapper freezeMonthMapper;
    
    @Override
    public int save(FreezeMonth freezeMonth) {
        return freezeMonthMapper.save(freezeMonth);
    }

    @Override
    public int saveBatch(List<FreezeMonth> freezeMonths) {
        return freezeMonthMapper.saveBatch(freezeMonths);
    }
    
    @Override
    public int update(FreezeMonth freezeMonth) {
        return freezeMonthMapper.update(freezeMonth);
    }

    @Override
    public int deleteById(String id) {
        return freezeMonthMapper.deleteById(id);
    }

    @Override
    public int delete(FreezeMonth freezeMonth) {
        return freezeMonthMapper.delete(freezeMonth);
    }
    
    @Override
    public int deleteByIds(List<String> ids) {
        return freezeMonthMapper.deleteByIds(ids);
    }

    @Override
    public FreezeMonth getById(String id) {
        return freezeMonthMapper.getById(id);
    }

    @Override
    public FreezeMonth getData(FreezeMonth freezeMonth) {
        return freezeMonthMapper.getData(freezeMonth);
    }

    @Override
    public int count(FreezeMonthQueryParam param) {
        return freezeMonthMapper.count(param);
    }

    @Override
    public List<FreezeMonth> query(FreezeMonthQueryParam param, int start,
            int end) {
        return freezeMonthMapper.query(param, start, end);
    }

    @Override
    public List<FreezeMonth> queryAll(FreezeMonthQueryParam param) {
        return freezeMonthMapper.queryAll(param);
    }
}
