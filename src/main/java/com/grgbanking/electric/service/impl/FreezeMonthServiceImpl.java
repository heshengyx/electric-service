package com.grgbanking.electric.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.grgbanking.electric.dao.IFreezeMonthDao;
import com.grgbanking.electric.data.FreezeMonthData;
import com.grgbanking.electric.entity.FreezeMonth;
import com.grgbanking.electric.page.IPage;
import com.grgbanking.electric.page.IPagination;
import com.grgbanking.electric.page.Pager;
import com.grgbanking.electric.param.FreezeMonthQueryParam;
import com.grgbanking.electric.service.IFreezeMonthService;
import com.grgbanking.electric.util.UUIDGeneratorUtil;


@Service("freezeMonthService")
public class FreezeMonthServiceImpl implements IFreezeMonthService {

    @Autowired
    private IFreezeMonthDao freezeMonthDao;
    
    @Override
    public void save(FreezeMonth freezeMonth) {
        Date sampleTime = freezeMonth.getSampleTime();
if (null != sampleTime) {
throw new DataAccessResourceFailureException("采样时间不能为空");
}

        freezeMonth.setId(UUIDGeneratorUtil.getUUID());
        freezeMonth.setCreateTime(new Date());
        
        int count = freezeMonthDao.save(freezeMonth);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据保存失败");
        }
    }

    @Override
    public void saveBatch(List<FreezeMonth> freezeMonths) {
        FreezeMonth freezeMonth = null;
        for (int i = 0; i < freezeMonths.size(); i++) {
            freezeMonth = freezeMonths.get(i);
            freezeMonth.setId(UUIDGeneratorUtil.getUUID());
            freezeMonth.setCreateTime(new Date());
            freezeMonths.set(i, freezeMonth);
        }
        int count = freezeMonthDao.saveBatch(freezeMonths);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据保存失败");
        }
    }
    
    @Override
    public void saveBatchData(FreezeMonthData data) {
                //
    }
    
    @Override
    public void update(FreezeMonth freezeMonth) {
        Date sampleTime = freezeMonth.getSampleTime();
if (null != sampleTime) {
throw new DataAccessResourceFailureException("采样时间不能为空");
}

        freezeMonth.setUpdateTime(new Date());
        int count = freezeMonthDao.update(freezeMonth);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据修改失败");
        }
    }

    @Override
    public void deleteById(String id) {
        if (!StringUtils.isEmpty(id)) {
            int count = freezeMonthDao.deleteById(id);
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
            int count = freezeMonthDao.deleteByIds(ids);
            if (count == 0) {
                throw new DataAccessResourceFailureException("数据删除失败");
            }
        } else {
            throw new DataAccessResourceFailureException("数据删除失败");
        }
    }

    @Override
    public void delete(FreezeMonth freezeMonth) {
        int count = freezeMonthDao.delete(freezeMonth);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据删除失败");
        }
    }

    @Override
    public FreezeMonth getById(String id) {
        return freezeMonthDao.getById(id);
    }

    @Override
    public FreezeMonth getData(FreezeMonth freezeMonth) {
        return freezeMonthDao.getData(freezeMonth);
    }
    
    @Override
    public void saveOrUpdate(FreezeMonth freezeMonth) {
        if (StringUtils.isEmpty(freezeMonth.getId())) {
            save(freezeMonth);
        } else {
            update(freezeMonth);
        }
    }

    @Override
    public IPage<FreezeMonth> query(final FreezeMonthQueryParam param) {
        int page = param.getPage() <= 0 ? 1 : param.getPage();
        int rows = param.getRows() <= 0 ? 10 : param.getRows();
        return Pager.execute(new IPagination<FreezeMonth>() {

            @Override
            public int count() {
                return freezeMonthDao.count(param);
            }

            @Override
            public List<FreezeMonth> query(int start, int end) {
                return freezeMonthDao.query(param, start, end);
            }
        }, page, rows);
    }
    
    @Override
	public List<FreezeMonth> queryAll(FreezeMonthQueryParam param) {
		return freezeMonthDao.queryAll(param);
	}
}