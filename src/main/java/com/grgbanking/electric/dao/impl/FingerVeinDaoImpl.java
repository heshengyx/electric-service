package com.grgbanking.electric.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.electric.dao.IFingerVeinDao;
import com.grgbanking.electric.entity.FingerVein;
import com.grgbanking.electric.mapper.IFingerVeinMapper;
import com.grgbanking.electric.param.FingerVeinQueryParam;


@Repository
public class FingerVeinDaoImpl implements IFingerVeinDao {

    @Autowired
    private IFingerVeinMapper fingerVeinMapper;
    
    @Override
    public int save(FingerVein fingerVein) {
        return fingerVeinMapper.save(fingerVein);
    }

    @Override
    public int saveBatch(List<FingerVein> fingerVeins) {
        return fingerVeinMapper.saveBatch(fingerVeins);
    }
    
    @Override
    public int update(FingerVein fingerVein) {
        return fingerVeinMapper.update(fingerVein);
    }

    @Override
    public int deleteById(String id) {
        return fingerVeinMapper.deleteById(id);
    }

    @Override
    public int delete(FingerVein fingerVein) {
        return fingerVeinMapper.delete(fingerVein);
    }
    
    @Override
    public int deleteByIds(List<String> ids) {
        return fingerVeinMapper.deleteByIds(ids);
    }

    @Override
    public FingerVein getById(String id) {
        return fingerVeinMapper.getById(id);
    }

    @Override
    public FingerVein getData(FingerVein fingerVein) {
        return fingerVeinMapper.getData(fingerVein);
    }

    @Override
    public int count(FingerVeinQueryParam param) {
        return fingerVeinMapper.count(param);
    }

    @Override
    public List<FingerVein> query(FingerVeinQueryParam param, int start,
            int end) {
        return fingerVeinMapper.query(param, start, end);
    }

    @Override
    public List<FingerVein> queryAll(FingerVeinQueryParam param) {
        return fingerVeinMapper.queryAll(param);
    }
}
