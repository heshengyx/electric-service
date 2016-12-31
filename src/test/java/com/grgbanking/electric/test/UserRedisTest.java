package com.grgbanking.electric.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grgbanking.electric.dao.IUserDao;
import com.grgbanking.electric.entity.User;
import com.grgbanking.electric.util.UUIDGeneratorUtil;

public class UserRedisTest extends BaseRedisTest {

	@Autowired
	private IUserDao userDao;
	
	@Test
	public void testSave() {
		User user = new User();
		user.setId("7F3EC9CA888F4FF0B5686E2D4FC7F42A");
		user.setName("王五");
		userDao.save(user);
	}
	
	@Test
	public void testSaveList() {
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < 5; i++) {
			User user = new User();
			user.setId(UUIDGeneratorUtil.getUUID());
			user.setName("李四" + i);
			users.add(user);
		}
		userDao.saveBatch(users);
	}
	
	@Test
	public void testGetList() {
		List<User> users = userDao.queryAll(null);
		for (User user : users) {
			System.out.println(user.getName());
		}
	}
	
	@Test
	public void testGetById() {
		User user = userDao.getById("7F3EC9CA888F4FF0B5686E2D4FC7F42A");
		System.out.println(user.getName());
	}
}
