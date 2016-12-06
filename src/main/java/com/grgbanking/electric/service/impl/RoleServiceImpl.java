package com.grgbanking.electric.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.grgbanking.electric.dao.IRoleDao;
import com.grgbanking.electric.data.RoleData;
import com.grgbanking.electric.entity.Role;
import com.grgbanking.electric.page.IPage;
import com.grgbanking.electric.page.IPagination;
import com.grgbanking.electric.page.Pager;
import com.grgbanking.electric.param.RoleQueryParam;
import com.grgbanking.electric.service.IRoleService;
import com.grgbanking.electric.util.UUIDGeneratorUtil;


@Service("roleService")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;
    
    @Override
    public void save(Role role) {
        String name = role.getName();
if (StringUtils.isEmpty(name)) {
throw new DataAccessResourceFailureException("监测点编号不能为空");
}

        role.setId(UUIDGeneratorUtil.getUUID());
        role.setCreateTime(new Date());
        
        int count = roleDao.save(role);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据保存失败");
        }
    }

    @Override
    public void saveBatch(List<Role> roles) {
        Role role = null;
        for (int i = 0; i < roles.size(); i++) {
            role = roles.get(i);
            role.setId(UUIDGeneratorUtil.getUUID());
            role.setCreateTime(new Date());
            roles.set(i, role);
        }
        int count = roleDao.saveBatch(roles);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据保存失败");
        }
    }
    
    @Override
    public void saveBatchData(RoleData data) {
                //
    }
    
    @Override
    public void update(Role role) {
        String name = role.getName();
if (StringUtils.isEmpty(name)) {
throw new DataAccessResourceFailureException("监测点编号不能为空");
}

        role.setUpdateTime(new Date());
        int count = roleDao.update(role);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据修改失败");
        }
    }

    @Override
    public void deleteById(String id) {
        if (!StringUtils.isEmpty(id)) {
            int count = roleDao.deleteById(id);
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
            int count = roleDao.deleteByIds(ids);
            if (count == 0) {
                throw new DataAccessResourceFailureException("数据删除失败");
            }
        } else {
            throw new DataAccessResourceFailureException("数据删除失败");
        }
    }

    @Override
    public void delete(Role role) {
        int count = roleDao.delete(role);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据删除失败");
        }
    }

    @Override
    public Role getById(String id) {
        return roleDao.getById(id);
    }

    @Override
    public Role getData(Role role) {
        return roleDao.getData(role);
    }
    
    @Override
    public void saveOrUpdate(Role role) {
        if (StringUtils.isEmpty(role.getId())) {
            save(role);
        } else {
            update(role);
        }
    }

    @Override
    public IPage<Role> query(final RoleQueryParam param) {
        int page = param.getPage() <= 0 ? 1 : param.getPage();
        int rows = param.getRows() <= 0 ? 10 : param.getRows();
        return Pager.execute(new IPagination<Role>() {

            @Override
            public int count() {
                return roleDao.count(param);
            }

            @Override
            public List<Role> query(int start, int end) {
                return roleDao.query(param, start, end);
            }
        }, page, rows);
    }
    
    @Override
	public List<Role> queryAll(RoleQueryParam param) {
		return roleDao.queryAll(param);
	}
}