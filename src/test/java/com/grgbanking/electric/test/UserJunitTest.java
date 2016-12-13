package com.grgbanking.electric.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grgbanking.electric.entity.User;
import com.grgbanking.electric.service.IUserService;
import com.grgbanking.electric.util.UUIDGeneratorUtil;
import com.grgbanking.electric.page.IPage;
import com.grgbanking.electric.param.UserQueryParam;

public class UserJunitTest extends BaseJunitTest {

	@Autowired
	private IUserService userService;
	
	@Test
	public void testSave() {
		User user = new User();
		user.setName("李四");
		user.setCode("sili");
		user.setAccount("sili");
		user.setPassword("123456");
		user.setAdmin("1");
		user.setSex("1");
		userService.save(user);
		
	}
	
	@Test
	public void testSaveBatch() {
		List<User> users = new ArrayList<User>();
		for (int i = 10; i < 50; i++) {
			User user = new User();
			users.add(user);
		}
		userService.saveBatch(users);
	}
	
	@Test
	public void testQuery() {
		UserQueryParam param = new UserQueryParam();
		param.setPage(1);
		param.setRows(20);
		IPage<User> users = userService.query(param);
		System.out.println(users.getRows().size());
	}
	
	@Test
	public void testQueryAll() {
		UserQueryParam param = new UserQueryParam();
		List<User> users = userService.queryAll(param);
		for (User user : users) {
			System.out.println(user.getId());
		}
	}
}
