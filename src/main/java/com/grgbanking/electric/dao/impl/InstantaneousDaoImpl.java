package com.grgbanking.electric.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.electric.dao.IInstantaneousDao;
import com.grgbanking.electric.entity.Instantaneous;
import com.grgbanking.electric.mapper.IInstantaneousMapper;
import com.grgbanking.electric.param.InstantaneousQueryParam;


@Repository
public class InstantaneousDaoImpl implements IInstantaneousDao {

    @Autowired
    private IInstantaneousMapper instantaneousMapper;
    
    @Override
    public int save(Instantaneous instantaneous) {
        return instantaneousMapper.save(instantaneous);
    }

    @Override
    public int saveBatch(List<Instantaneous> instantaneouss) {
        return instantaneousMapper.saveBatch(instantaneouss);
    }
    
    @Override
    public int update(Instantaneous instantaneous) {
        return instantaneousMapper.update(instantaneous);
    }

    @Override
    public int deleteById(String id) {
        return instantaneousMapper.deleteById(id);
    }

    @Override
    public int delete(Instantaneous instantaneous) {
        return instantaneousMapper.delete(instantaneous);
    }
    
    @Override
    public int deleteByIds(List<String> ids) {
        return instantaneousMapper.deleteByIds(ids);
    }

    @Override
    public Instantaneous getById(String id) {
        return instantaneousMapper.getById(id);
    }

    @Override
    public Instantaneous getData(Instantaneous instantaneous) {
        return instantaneousMapper.getData(instantaneous);
    }

    @Override
    public int count(InstantaneousQueryParam param) {
        return instantaneousMapper.count(param);
    }

    @Override
    public List<Instantaneous> query(InstantaneousQueryParam param, int start,
            int end) {
        return instantaneousMapper.query(param, start, end);
    }

    @Override
    public List<Instantaneous> queryAll(InstantaneousQueryParam param) {
        return instantaneousMapper.queryAll(param);
    }
}
