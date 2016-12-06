package com.grgbanking.electric.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.electric.dao.IPermissionDao;
import com.grgbanking.electric.entity.Permission;
import com.grgbanking.electric.mapper.IPermissionMapper;
import com.grgbanking.electric.param.PermissionQueryParam;


@Repository
public class PermissionDaoImpl implements IPermissionDao {

    @Autowired
    private IPermissionMapper permissionMapper;
    
    @Override
    public int save(Permission permission) {
        return permissionMapper.save(permission);
    }

    @Override
    public int saveBatch(List<Permission> permissions) {
        return permissionMapper.saveBatch(permissions);
    }
    
    @Override
    public int update(Permission permission) {
        return permissionMapper.update(permission);
    }

    @Override
    public int deleteById(String id) {
        return permissionMapper.deleteById(id);
    }

    @Override
    public int delete(Permission permission) {
        return permissionMapper.delete(permission);
    }
    
    @Override
    public int deleteByIds(List<String> ids) {
        return permissionMapper.deleteByIds(ids);
    }

    @Override
    public Permission getById(String id) {
        return permissionMapper.getById(id);
    }

    @Override
    public Permission getData(Permission permission) {
        return permissionMapper.getData(permission);
    }

    @Override
    public int count(PermissionQueryParam param) {
        return permissionMapper.count(param);
    }

    @Override
    public List<Permission> query(PermissionQueryParam param, int start,
            int end) {
        return permissionMapper.query(param, start, end);
    }

    @Override
    public List<Permission> queryAll(PermissionQueryParam param) {
        return permissionMapper.queryAll(param);
    }
}
