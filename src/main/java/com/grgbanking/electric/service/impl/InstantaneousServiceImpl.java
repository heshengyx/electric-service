package com.grgbanking.electric.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.grgbanking.electric.dao.IInstantaneousDao;
import com.grgbanking.electric.data.InstantaneousData;
import com.grgbanking.electric.entity.Instantaneous;
import com.grgbanking.electric.page.IPage;
import com.grgbanking.electric.page.IPagination;
import com.grgbanking.electric.page.Pager;
import com.grgbanking.electric.param.InstantaneousQueryParam;
import com.grgbanking.electric.service.IInstantaneousService;
import com.grgbanking.electric.util.UUIDGeneratorUtil;


@Service("instantaneousService")
public class InstantaneousServiceImpl implements IInstantaneousService {

    @Autowired
    private IInstantaneousDao instantaneousDao;
    
    @Override
    public void save(Instantaneous instantaneous) {
        instantaneous.setId(UUIDGeneratorUtil.getUUID());
        instantaneous.setCreateTime(new Date());
        
        int count = instantaneousDao.save(instantaneous);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据保存失败");
        }
    }

    @Override
    public void saveBatch(List<Instantaneous> instantaneouss) {
        Instantaneous instantaneous = null;
        for (int i = 0; i < instantaneouss.size(); i++) {
            instantaneous = instantaneouss.get(i);
            instantaneous.setId(UUIDGeneratorUtil.getUUID());
            instantaneous.setCreateTime(new Date());
            instantaneouss.set(i, instantaneous);
        }
        int count = instantaneousDao.saveBatch(instantaneouss);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据保存失败");
        }
    }
    
    @Override
    public void saveBatchData(InstantaneousData data) {
                //
    }
    
    @Override
    public void update(Instantaneous instantaneous) {
        instantaneous.setUpdateTime(new Date());
        int count = instantaneousDao.update(instantaneous);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据修改失败");
        }
    }

    @Override
    public void deleteById(String id) {
        if (!StringUtils.isEmpty(id)) {
            int count = instantaneousDao.deleteById(id);
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
            int count = instantaneousDao.deleteByIds(ids);
            if (count == 0) {
                throw new DataAccessResourceFailureException("数据删除失败");
            }
        } else {
            throw new DataAccessResourceFailureException("数据删除失败");
        }
    }

    @Override
    public void delete(Instantaneous instantaneous) {
        int count = instantaneousDao.delete(instantaneous);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据删除失败");
        }
    }

    @Override
    public Instantaneous getById(String id) {
        return instantaneousDao.getById(id);
    }

    @Override
    public Instantaneous getData(Instantaneous instantaneous) {
        return instantaneousDao.getData(instantaneous);
    }
    
    @Override
    public void saveOrUpdate(Instantaneous instantaneous) {
        if (StringUtils.isEmpty(instantaneous.getId())) {
            save(instantaneous);
        } else {
            update(instantaneous);
        }
    }

    @Override
    public IPage<Instantaneous> query(final InstantaneousQueryParam param) {
        int page = param.getPage() <= 0 ? 1 : param.getPage();
        int rows = param.getRows() <= 0 ? 10 : param.getRows();
        return Pager.execute(new IPagination<Instantaneous>() {

            @Override
            public int count() {
                return instantaneousDao.count(param);
            }

            @Override
            public List<Instantaneous> query(int start, int end) {
                return instantaneousDao.query(param, start, end);
            }
        }, page, rows);
    }
    
    @Override
	public List<Instantaneous> queryAll(InstantaneousQueryParam param) {
		return instantaneousDao.queryAll(param);
	}
}