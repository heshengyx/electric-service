package com.grgbanking.electric.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grgbanking.electric.entity.Organization;
import com.grgbanking.electric.service.IOrganizationService;

public class OrganizationJunitTest extends BaseJunitTest {

	@Autowired
	private IOrganizationService organizationService;
	
	@Test
	public void testSaveBatch() {
		List<Organization> organizations = new ArrayList<Organization>();
		for (int i = 10; i < 50; i++) {
			Organization organization = new Organization();
			organization.setName("集团" + i);
			organization.setCode("1000" + i);
			organization.setLevel(1);
			organizations.add(organization);
		}
		organizationService.saveBatch(organizations);
	}
}
