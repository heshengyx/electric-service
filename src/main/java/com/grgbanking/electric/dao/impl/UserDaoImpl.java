package com.grgbanking.electric.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.electric.dao.IUserDao;
import com.grgbanking.electric.entity.User;
import com.grgbanking.electric.mapper.IUserMapper;

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
	public User getUserByAccount(String account) {
		return userMapper.getUserByAccount(account);
	}

	
}
