package com.grgbanking.electric.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grgbanking.electric.entity.RolePermission;
import com.grgbanking.electric.service.IRolePermissionService;
import com.grgbanking.electric.param.RolePermissionQueryParam;

public class RolePermissionJunitTest extends BaseJunitTest {

	@Autowired
	private IRolePermissionService rolePermissionService;
	
	@Test
	public void testSaveBatch() {
		List<RolePermission> rolePermissions = new ArrayList<RolePermission>();
		for (int i = 10; i < 50; i++) {
			RolePermission rolePermission = new RolePermission();
			rolePermissions.add(rolePermission);
		}
		rolePermissionService.saveBatch(rolePermissions);
	}
	
	@Test
	public void testQueryAll() {
		RolePermissionQueryParam param = new RolePermissionQueryParam();
		List<RolePermission> rolePermissions = rolePermissionService.queryAll(param);
		for (RolePermission rolePermission : rolePermissions) {
			System.out.println(rolePermission.getId());
		}
	}
}
