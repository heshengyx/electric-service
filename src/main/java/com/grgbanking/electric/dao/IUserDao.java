package com.grgbanking.electric.dao;

import java.util.List;

import com.grgbanking.electric.entity.User;

public interface IUserDao {
	
	int save(User user);
	int saveBatch(List<User> users);
	User getUserByAccount(String account);
}
