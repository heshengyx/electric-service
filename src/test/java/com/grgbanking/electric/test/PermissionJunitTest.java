package com.grgbanking.electric.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grgbanking.electric.entity.Permission;
import com.grgbanking.electric.service.IPermissionService;
import com.grgbanking.electric.param.PermissionQueryParam;

public class PermissionJunitTest extends BaseJunitTest {

	@Autowired
	private IPermissionService permissionService;
	
	@Test
	public void testSaveBatch() {
		List<Permission> permissions = new ArrayList<Permission>();
		for (int i = 10; i < 50; i++) {
			Permission permission = new Permission();
			permissions.add(permission);
		}
		permissionService.saveBatch(permissions);
	}
	
	@Test
	public void testQueryAll() {
		PermissionQueryParam param = new PermissionQueryParam();
		List<Permission> permissions = permissionService.queryAll(param);
		for (Permission permission : permissions) {
			System.out.println(permission.getId());
		}
	}
}
