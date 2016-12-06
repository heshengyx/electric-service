package com.grgbanking.electric.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.electric.dao.IRoleDao;
import com.grgbanking.electric.entity.Role;
import com.grgbanking.electric.mapper.IRoleMapper;
import com.grgbanking.electric.param.RoleQueryParam;


@Repository
public class RoleDaoImpl implements IRoleDao {

    @Autowired
    private IRoleMapper roleMapper;
    
    @Override
    public int save(Role role) {
        return roleMapper.save(role);
    }

    @Override
    public int saveBatch(List<Role> roles) {
        return roleMapper.saveBatch(roles);
    }
    
    @Override
    public int update(Role role) {
        return roleMapper.update(role);
    }

    @Override
    public int deleteById(String id) {
        return roleMapper.deleteById(id);
    }

    @Override
    public int delete(Role role) {
        return roleMapper.delete(role);
    }
    
    @Override
    public int deleteByIds(List<String> ids) {
        return roleMapper.deleteByIds(ids);
    }

    @Override
    public Role getById(String id) {
        return roleMapper.getById(id);
    }

    @Override
    public Role getData(Role role) {
        return roleMapper.getData(role);
    }

    @Override
    public int count(RoleQueryParam param) {
        return roleMapper.count(param);
    }

    @Override
    public List<Role> query(RoleQueryParam param, int start,
            int end) {
        return roleMapper.query(param, start, end);
    }

    @Override
    public List<Role> queryAll(RoleQueryParam param) {
        return roleMapper.queryAll(param);
    }
}
