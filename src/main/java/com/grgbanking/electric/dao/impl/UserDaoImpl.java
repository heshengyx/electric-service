package com.grgbanking.electric.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.electric.dao.IUserDao;
import com.grgbanking.electric.entity.User;
import com.grgbanking.electric.mapper.IUserMapper;
import com.grgbanking.electric.param.UserQueryParam;

@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    private IUserMapper userMapper;
    
    @Override
    public int save(User user) {
        return userMapper.save(user);
    }

    @Override
    public int saveBatch(List<User> users) {
        return userMapper.saveBatch(users);
    }
    
    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int deleteById(String id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int delete(User user) {
        return userMapper.delete(user);
    }
    
    @Override
    public int deleteByIds(List<String> ids) {
        return userMapper.deleteByIds(ids);
    }

    @Override
    public User getById(String id) {
        return userMapper.getById(id);
    }

    @Override
    public User getData(User user) {
        return userMapper.getData(user);
    }

    @Override
    public int count(UserQueryParam param) {
        return userMapper.count(param);
    }

    @Override
    public List<User> query(UserQueryParam param, int start,
            int end) {
        return userMapper.query(param, start, end);
    }

    @Override
    public List<User> queryAll(UserQueryParam param) {
        return userMapper.queryAll(param);
    }
}
