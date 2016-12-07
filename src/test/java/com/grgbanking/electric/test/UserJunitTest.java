package com.grgbanking.electric.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grgbanking.electric.entity.User;
import com.grgbanking.electric.service.IUserService;

public class UserJunitTest extends BaseJunitTest {

	@Autowired
	private IUserService userService;
	
	@Test
	public void testGetUserByAccount() {
		User user = userService.getUserByAccount("admin");
		System.out.println(user.getId());
	}
	
	@Test
	public void testSave() {
		User user = new User();
		user.setName("张三");
		user.setSex(1);
		user.setAccount("admin");
		user.setPassword("123456");
		user.setEmail("admin@163.com");
		user.setPhone("13310002000");
		//user.setOrgId(orgId);
		try {
			userService.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
