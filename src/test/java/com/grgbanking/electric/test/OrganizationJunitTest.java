package com.grgbanking.electric.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.grgbanking.electric.dao.IOrganizationDao;
import com.grgbanking.electric.entity.Organization;
import com.grgbanking.electric.enums.StateEnum;
import com.grgbanking.electric.param.OrganizationQueryParam;
import com.grgbanking.electric.service.IOrganizationService;
import com.grgbanking.electric.tree.Tree;

public class OrganizationJunitTest extends BaseJunitTest {

	@Autowired
	private IOrganizationService organizationService;
	
	@Autowired
	private IOrganizationDao organizationDao;
	
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
	
	@Test
	public void testTree() {
		List<Tree> trees = null;
		OrganizationQueryParam param = new OrganizationQueryParam();
		List<Organization> organizations = organizationDao.queryAll(param);
		if (!CollectionUtils.isEmpty(organizations)) {
			trees = tree(organizations, "");
		}
		for (Tree tree : trees) {
			System.out.println(tree.getChildren().size());
		}
	}
	
	public List<Tree> tree(List<Organization> organizations, String parentId) {
		List<Tree> trees = new ArrayList<Tree>();
		for (Organization organization : organizations) {
			if (parentId.equals(organization.getParentId()) || organization.getParentId() == null) {
				Tree tree = new Tree();
				tree.setId(organization.getId());
				tree.setText(organization.getName());
				tree.setState(StateEnum.OPEN.name().toLowerCase());
				trees.add(tree);
				tree.setChildren(tree(organizations, organization.getId()));
			}
		}
		return trees;
	}
}
