package com.grgbanking.electric.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grgbanking.electric.entity.RoleOrganization;
import com.grgbanking.electric.service.IRoleOrganizationService;
import com.grgbanking.electric.param.RoleOrganizationQueryParam;

public class RoleOrganizationJunitTest extends BaseJunitTest {

	@Autowired
	private IRoleOrganizationService roleOrganizationService;
	
	@Test
	public void testSaveBatch() {
		List<RoleOrganization> roleOrganizations = new ArrayList<RoleOrganization>();
		for (int i = 10; i < 50; i++) {
			RoleOrganization roleOrganization = new RoleOrganization();
			roleOrganizations.add(roleOrganization);
		}
		roleOrganizationService.saveBatch(roleOrganizations);
	}
	
	@Test
	public void testQueryAll() {
		RoleOrganizationQueryParam param = new RoleOrganizationQueryParam();
		List<RoleOrganization> roleOrganizations = roleOrganizationService.queryAll(param);
		for (RoleOrganization roleOrganization : roleOrganizations) {
			System.out.println(roleOrganization.getId());
		}
	}
}
