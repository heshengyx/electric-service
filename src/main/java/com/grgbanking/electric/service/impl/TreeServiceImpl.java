package com.grgbanking.electric.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.grgbanking.electric.dao.IOrganizationDao;
import com.grgbanking.electric.dao.ITerminalDao;
import com.grgbanking.electric.entity.Organization;
import com.grgbanking.electric.entity.Terminal;
import com.grgbanking.electric.enums.StateEnum;
import com.grgbanking.electric.param.OrganizationQueryParam;
import com.grgbanking.electric.param.TerminalQueryParam;
import com.grgbanking.electric.service.ITreeService;
import com.grgbanking.electric.tree.Tree;

@Service("treeService")
public class TreeServiceImpl implements ITreeService {

	@Autowired
	private IOrganizationDao organizationDao;
	
	@Autowired
	private ITerminalDao terminalDao;
	
	@Override
	public List<Tree> tree(OrganizationQueryParam param) {
		List<Tree> trees = null; 
		List<Organization> organizations = organizationDao.queryAll(param);
		if (!CollectionUtils.isEmpty(organizations)) {
			trees = new ArrayList<Tree>(); 
			Tree tree = null;
			Map<String, List<Tree>> terminalMap = new HashMap<String, List<Tree>>();
			
			String terminalFlag = param.getTerminalFlag();
			if ("1".equals(terminalFlag)) {
				//查询所有已分配的终端
				TerminalQueryParam queryParam = new TerminalQueryParam();
				queryParam.setOrgIdFlag("true");
				List<Terminal> terminals = terminalDao.queryAll(queryParam);
				
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
			}
			
			Map<String, List<Tree>> organizationMap = new HashMap<String, List<Tree>>();
			for (Organization organization : organizations) {
				if (StringUtils.isEmpty(organization.getParentId())) {
					tree = new Tree();
					tree.setId(organization.getId());
					tree.setText(organization.getName());
					tree.setState(StateEnum.OPEN.name().toLowerCase());
					trees.add(tree);
				} else {
					List<Tree> treeList = organizationMap.get(organization.getParentId());
					if (CollectionUtils.isEmpty(treeList)) {
						treeList = new ArrayList<Tree>();
						tree = new Tree();
						tree.setId(organization.getId());
						tree.setText(organization.getName());
						tree.setChildren(terminalMap.get(organization.getId()));
						Map<String, String> attributes = new HashMap<String, String>(1);
						attributes.put("parentId", organization.getParentId());
						tree.setAttributes(attributes);
						treeList.add(tree);
						organizationMap.put(organization.getParentId(), treeList);
					} else {
						tree = new Tree();
						tree.setId(organization.getId());
						tree.setText(organization.getName());
						tree.setChildren(terminalMap.get(organization.getId()));
						Map<String, String> attributes = new HashMap<String, String>(1);
						attributes.put("parentId", organization.getParentId());
						tree.setAttributes(attributes);
						treeList.add(tree);
					}
				}
			}
			
			
			for (Tree _tree : trees) {
				List<Tree> treeList = organizationMap.get(_tree.getId());
				if (!CollectionUtils.isEmpty(treeList)) {
					_tree.setChildren(treeList);
				}
			}
		}
		return trees;
	}

}
