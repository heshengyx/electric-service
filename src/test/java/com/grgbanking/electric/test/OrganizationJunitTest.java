package com.grgbanking.electric.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.grgbanking.electric.dao.IOrganizationDao;
import com.grgbanking.electric.entity.Organization;
import com.grgbanking.electric.entity.Terminal;
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
		List<Organization> organizations = new ArrayList<Organization>();
		Organization o = new Organization();
		o.setId("1");
		o.setName("父1");
		organizations.add(o);
		
		o = new Organization();
		o.setId("2");
		o.setName("子1");
		o.setParentId("1");
		organizations.add(o);
		o = new Organization();
		o.setId("3");
		o.setName("子子1");
		o.setParentId("2");
		organizations.add(o);
		o = new Organization();
		o.setId("4");
		o.setName("子2");
		o.setParentId("1");
		organizations.add(o);
		o = new Organization();
		o.setId("5");
		o.setName("父2");
		organizations.add(o);
		
		Map<String, Organization> map = new HashMap<String, Organization>();
		Map<String, Tree> treeMap = new HashMap<String, Tree>();
		
		Tree tree = null;
		
		Map<String, List<Tree>> terminalMap = new HashMap<String, List<Tree>>();
		
		List<Terminal> terminals = new ArrayList<Terminal>();
		Terminal t = new Terminal();
		t.setId("t1");
		t.setName("终端1");
		t.setOrgId("3");
		terminals.add(t);
		t = new Terminal();
		t.setId("t2");
		t.setName("终端2");
		t.setOrgId("2");
		terminals.add(t);
		
		for (Terminal terminal : terminals) {
			List<Tree> treeList = terminalMap.get(terminal.getOrgId());
			if (CollectionUtils.isEmpty(treeList)) {
				treeList = new ArrayList<Tree>();
				tree = new Tree();
				tree.setId(terminal.getId());
				tree.setText(terminal.getName());
				treeList.add(tree);
				terminalMap.put(terminal.getOrgId(), treeList);
			} else {
				tree = new Tree();
				tree.setId(terminal.getId());
				tree.setText(terminal.getName());
				treeList.add(tree);
			}
		}
		
		List<Tree> trees = new ArrayList<Tree>();
		OrganizationQueryParam param = new OrganizationQueryParam();
		//List<Organization> organizations = organizationDao.queryAll(param);
		if (!CollectionUtils.isEmpty(organizations)) {
			for (Organization organization : organizations) {
				map.put(organization.getId(), organization);
				
				tree = new Tree();
				tree.setId(organization.getId());
				tree.setText(organization.getName());
				tree.setState(StateEnum.OPEN.name().toLowerCase());
				tree.setParentId(organization.getParentId());
				treeMap.put(organization.getId(), tree);
			}
		}
		
		Map<String, Tree> treeMaps = new HashMap<String, Tree>();
		
		for (Map.Entry<String, Tree> entry : treeMap.entrySet()) {
			tree = entry.getValue();
			if (StringUtils.isEmpty(tree.getParentId())) {
				/*tree = new Tree();
				tree.setId(tree.getId());
				tree.setText(tree.getText());
				tree.setState(StateEnum.OPEN.name().toLowerCase());
				treeMaps.put(tree.getId(), tree);*/
			} else {
				Tree parentTree = treeMap.get(tree.getParentId());
				trees = parentTree.getChildren();
				if (trees == null) {
					trees = new ArrayList<Tree>();
				}
				List<Tree> childTree = terminalMap.get(tree.getId());
				if (!CollectionUtils.isEmpty(childTree)) {
					tree.setChildren(childTree);
				}
				trees.add(tree);
				parentTree.setChildren(trees);
				//treeMap.put(tree.getParentId(), parentTree);
				//treeMap.remove(tree.getId());
			}
		}
		
		trees = new ArrayList<Tree>();
		for (Map.Entry<String, Tree> entry : treeMap.entrySet()) {
			tree = entry.getValue();
			if (StringUtils.isEmpty(tree.getParentId())) {
				trees.add(tree);
			}
		}
		System.out.println(trees);
		showTree(trees);
	}
	
	private void showTree(List<Tree> trees) {
		for (Tree tree : trees) {
			System.out.println("treeName=" + tree.getText());
			if (!CollectionUtils.isEmpty(tree.getChildren())) {
				showTree(tree.getChildren());
			}
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
