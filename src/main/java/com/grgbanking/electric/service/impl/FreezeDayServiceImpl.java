package com.grgbanking.electric.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.grgbanking.electric.dao.IFreezeDayDao;
import com.grgbanking.electric.data.FreezeDayData;
import com.grgbanking.electric.entity.FreezeDay;
import com.grgbanking.electric.page.IPage;
import com.grgbanking.electric.page.IPagination;
import com.grgbanking.electric.page.Pager;
import com.grgbanking.electric.param.FreezeDayQueryParam;
import com.grgbanking.electric.service.IFreezeDayService;
import com.grgbanking.electric.util.UUIDGeneratorUtil;


@Service("freezeDayService")
public class FreezeDayServiceImpl implements IFreezeDayService {

    @Autowired
    private IFreezeDayDao freezeDayDao;
    
    @Override
    public void save(FreezeDay freezeDay) {
        Date sampleTime = freezeDay.getSampleTime();
if (null != sampleTime) {
throw new DataAccessResourceFailureException("采样时间不能为空");
}

        freezeDay.setId(UUIDGeneratorUtil.getUUID());
        freezeDay.setCreateTime(new Date());
        
        int count = freezeDayDao.save(freezeDay);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据保存失败");
        }
    }

    @Override
    public void saveBatch(List<FreezeDay> freezeDays) {
        FreezeDay freezeDay = null;
        for (int i = 0; i < freezeDays.size(); i++) {
            freezeDay = freezeDays.get(i);
            freezeDay.setId(UUIDGeneratorUtil.getUUID());
            freezeDay.setCreateTime(new Date());
            freezeDays.set(i, freezeDay);
        }
        int count = freezeDayDao.saveBatch(freezeDays);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据保存失败");
        }
    }
    
    @Override
    public void saveBatchData(FreezeDayData data) {
                //
    }
    
    @Override
    public void update(FreezeDay freezeDay) {
        Date sampleTime = freezeDay.getSampleTime();
if (null != sampleTime) {
throw new DataAccessResourceFailureException("采样时间不能为空");
}

        freezeDay.setUpdateTime(new Date());
        int count = freezeDayDao.update(freezeDay);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据修改失败");
        }
    }

    @Override
    public void deleteById(String id) {
        if (!StringUtils.isEmpty(id)) {
            int count = freezeDayDao.deleteById(id);
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
            int count = freezeDayDao.deleteByIds(ids);
            if (count == 0) {
                throw new DataAccessResourceFailureException("数据删除失败");
            }
        } else {
            throw new DataAccessResourceFailureException("数据删除失败");
        }
    }

    @Override
    public void delete(FreezeDay freezeDay) {
        int count = freezeDayDao.delete(freezeDay);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据删除失败");
        }
    }

    @Override
    public FreezeDay getById(String id) {
        return freezeDayDao.getById(id);
    }

    @Override
    public FreezeDay getData(FreezeDay freezeDay) {
        return freezeDayDao.getData(freezeDay);
    }
    
    @Override
    public void saveOrUpdate(FreezeDay freezeDay) {
        if (StringUtils.isEmpty(freezeDay.getId())) {
            save(freezeDay);
        } else {
            update(freezeDay);
        }
    }

    @Override
    public IPage<FreezeDay> query(final FreezeDayQueryParam param) {
        int page = param.getPage() <= 0 ? 1 : param.getPage();
        int rows = param.getRows() <= 0 ? 10 : param.getRows();
        return Pager.execute(new IPagination<FreezeDay>() {

            @Override
            public int count() {
                return freezeDayDao.count(param);
            }

            @Override
            public List<FreezeDay> query(int start, int end) {
                return freezeDayDao.query(param, start, end);
            }
        }, page, rows);
    }
    
    @Override
	public List<FreezeDay> queryAll(FreezeDayQueryParam param) {
		return freezeDayDao.queryAll(param);
	}
}