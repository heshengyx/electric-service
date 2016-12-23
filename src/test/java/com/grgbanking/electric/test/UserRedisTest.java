package com.grgbanking.electric.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grgbanking.electric.dao.IUserDao;
import com.grgbanking.electric.entity.User;

public class UserRedisTest extends BaseRedisTest {

	@Autowired
	private IUserDao userDao;
	
	@Test
	public void testSave() {
		User user = new User();
		user.setId("8F3EC9CA888F4FF0B5686E2D4FC7F42D");
		user.setName("李四");
		userDao.save(user);
	}
	
	@Test
	public void testGetById() {
		User user = userDao.getById("8F3EC9CA888F4FF0B5686E2D4FC7F42D");
		System.out.println(user.getName());
	}
}
