package com.grgbanking.electric.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.electric.dao.ICurveDao;
import com.grgbanking.electric.entity.Curve;
import com.grgbanking.electric.mapper.ICurveMapper;
import com.grgbanking.electric.param.CurveQueryParam;


@Repository
public class CurveDaoImpl implements ICurveDao {

    @Autowired
    private ICurveMapper curveMapper;
    
    @Override
    public int save(Curve curve) {
        return curveMapper.save(curve);
    }

    @Override
    public int saveBatch(List<Curve> curves) {
        return curveMapper.saveBatch(curves);
    }
    
    @Override
    public int update(Curve curve) {
        return curveMapper.update(curve);
    }

    @Override
    public int deleteById(String id) {
        return curveMapper.deleteById(id);
    }

    @Override
    public int delete(Curve curve) {
        return curveMapper.delete(curve);
    }
    
    @Override
    public int deleteByIds(List<String> ids) {
        return curveMapper.deleteByIds(ids);
    }

    @Override
    public Curve getById(String id) {
        return curveMapper.getById(id);
    }

    @Override
    public Curve getData(Curve curve) {
        return curveMapper.getData(curve);
    }

    @Override
    public int count(CurveQueryParam param) {
        return curveMapper.count(param);
    }

    @Override
    public List<Curve> query(CurveQueryParam param, int start,
            int end) {
        return curveMapper.query(param, start, end);
    }

    @Override
    public List<Curve> queryAll(CurveQueryParam param) {
        return curveMapper.queryAll(param);
    }
}
