package com.grgbanking.electric.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grgbanking.electric.entity.Role;
import com.grgbanking.electric.service.IRoleService;
import com.grgbanking.electric.param.RoleQueryParam;

public class RoleJunitTest extends BaseJunitTest {

	@Autowired
	private IRoleService roleService;
	
	@Test
	public void testSaveBatch() {
		List<Role> roles = new ArrayList<Role>();
		for (int i = 10; i < 50; i++) {
			Role role = new Role();
			roles.add(role);
		}
		roleService.saveBatch(roles);
	}
	
	@Test
	public void testQueryAll() {
		RoleQueryParam param = new RoleQueryParam();
		List<Role> roles = roleService.queryAll(param);
		for (Role role : roles) {
			System.out.println(role.getId());
		}
	}
}
