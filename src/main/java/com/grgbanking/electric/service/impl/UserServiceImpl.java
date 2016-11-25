package com.grgbanking.electric.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import com.grgbanking.electric.dao.IUserDao;
import com.grgbanking.electric.entity.User;
import com.grgbanking.electric.service.IUserService;
import com.grgbanking.electric.util.UUIDGeneratorUtil;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public void save(User user) {
		user.setId(UUIDGeneratorUtil.getUUID());
		user.setCreateTime(new Date());
		
		int count = userDao.save(user);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据保存失败");
		}
	}
	
	@Override
	public void saveBatch(List<User> users) {
		User user = null;
		for (int i = 0; i < users.size(); i++) {
			user = users.get(i);
			user.setId(UUIDGeneratorUtil.getUUID());
			user.setCreateTime(new Date());
			users.set(i, user);
		}
		int count = userDao.saveBatch(users);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据保存失败");
		}
	}
	
	@Override
	public User getUserByAccount(String account) {
		return userDao.getUserByAccount(account);
	}
}
