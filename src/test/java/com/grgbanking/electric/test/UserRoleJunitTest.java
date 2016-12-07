package com.grgbanking.electric.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grgbanking.electric.entity.UserRole;
import com.grgbanking.electric.service.IUserRoleService;
import com.grgbanking.electric.util.UUIDGeneratorUtil;
import com.grgbanking.electric.param.UserRoleQueryParam;

public class UserRoleJunitTest extends BaseJunitTest {

	@Autowired
	private IUserRoleService userRoleService;
	
	@Test
	public void testSaveBatch() {
		List<UserRole> userRoles = new ArrayList<UserRole>();
		for (int i = 10; i < 50; i++) {
			UserRole userRole = new UserRole();
			userRoles.add(userRole);
		}
		userRoleService.saveBatch(userRoles);
	}
	
	@Test
	public void testSave() {
		UserRole userRole = new UserRole();
		userRole.setId(UUIDGeneratorUtil.getUUID());
		userRole.setUserId("0761D3F110B74D8F9D176503B4E4C880");
		userRole.setRoleId("8B9D4A0B2206490597B83FBCD3F55F89");
		userRoleService.save(userRole);
	}
	
	@Test
	public void testQueryAll() {
		UserRoleQueryParam param = new UserRoleQueryParam();
		List<UserRole> userRoles = userRoleService.queryAll(param);
		for (UserRole userRole : userRoles) {
			System.out.println(userRole.getId());
		}
	}
}
