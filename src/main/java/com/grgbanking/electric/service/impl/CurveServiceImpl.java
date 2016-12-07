package com.grgbanking.electric.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.grgbanking.electric.dao.ICurveDao;
import com.grgbanking.electric.data.CurveData;
import com.grgbanking.electric.entity.Curve;
import com.grgbanking.electric.page.IPage;
import com.grgbanking.electric.page.IPagination;
import com.grgbanking.electric.page.Pager;
import com.grgbanking.electric.param.CurveQueryParam;
import com.grgbanking.electric.service.ICurveService;
import com.grgbanking.electric.util.UUIDGeneratorUtil;


@Service("curveService")
public class CurveServiceImpl implements ICurveService {

    @Autowired
    private ICurveDao curveDao;
    
    @Override
    public void save(Curve curve) {
        Date sampleTime = curve.getSampleTime();
if (null != sampleTime) {
throw new DataAccessResourceFailureException("采样时间不能为空");
}

        curve.setId(UUIDGeneratorUtil.getUUID());
        curve.setCreateTime(new Date());
        
        int count = curveDao.save(curve);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据保存失败");
        }
    }

    @Override
    public void saveBatch(List<Curve> curves) {
        Curve curve = null;
        for (int i = 0; i < curves.size(); i++) {
            curve = curves.get(i);
            curve.setId(UUIDGeneratorUtil.getUUID());
            curve.setCreateTime(new Date());
            curves.set(i, curve);
        }
        int count = curveDao.saveBatch(curves);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据保存失败");
        }
    }
    
    @Override
    public void saveBatchData(CurveData data) {
                //
    }
    
    @Override
    public void update(Curve curve) {
        Date sampleTime = curve.getSampleTime();
if (null != sampleTime) {
throw new DataAccessResourceFailureException("采样时间不能为空");
}

        curve.setUpdateTime(new Date());
        int count = curveDao.update(curve);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据修改失败");
        }
    }

    @Override
    public void deleteById(String id) {
        if (!StringUtils.isEmpty(id)) {
            int count = curveDao.deleteById(id);
            if (count == 0) {
                throw new DataAccessResourceFailureException("数据删除失败");
            }
        } else {
            throw new DataAccessResourceFailureException("数据删除失败");
        }
    }
    
    @Override
    public void deleteByIds(List<String> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            int count = curveDao.deleteByIds(ids);
            if (count == 0) {
                throw new DataAccessResourceFailureException("数据删除失败");
            }
        } else {
            throw new DataAccessResourceFailureException("数据删除失败");
        }
    }

    @Override
    public void delete(Curve curve) {
        int count = curveDao.delete(curve);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据删除失败");
        }
    }

    @Override
    public Curve getById(String id) {
        return curveDao.getById(id);
    }

    @Override
    public Curve getData(Curve curve) {
        return curveDao.getData(curve);
    }
    
    @Override
    public void saveOrUpdate(Curve curve) {
        if (StringUtils.isEmpty(curve.getId())) {
            save(curve);
        } else {
            update(curve);
        }
    }

    @Override
    public IPage<Curve> query(final CurveQueryParam param) {
        int page = param.getPage() <= 0 ? 1 : param.getPage();
        int rows = param.getRows() <= 0 ? 10 : param.getRows();
        return Pager.execute(new IPagination<Curve>() {

            @Override
            public int count() {
                return curveDao.count(param);
            }

            @Override
            public List<Curve> query(int start, int end) {
                return curveDao.query(param, start, end);
            }
        }, page, rows);
    }
    
    @Override
	public List<Curve> queryAll(CurveQueryParam param) {
		return curveDao.queryAll(param);
	}
}