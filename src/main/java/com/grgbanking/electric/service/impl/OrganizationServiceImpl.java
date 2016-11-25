package com.grgbanking.electric.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.grgbanking.electric.dao.IOrganizationDao;
import com.grgbanking.electric.entity.Organization;
import com.grgbanking.electric.enums.StateEnum;
import com.grgbanking.electric.page.IPage;
import com.grgbanking.electric.page.IPagination;
import com.grgbanking.electric.page.Pager;
import com.grgbanking.electric.param.OrganizationQueryParam;
import com.grgbanking.electric.service.IOrganizationService;
import com.grgbanking.electric.tree.Tree;
import com.grgbanking.electric.util.UUIDGeneratorUtil;

@Service("organizationService")
public class OrganizationServiceImpl implements IOrganizationService {

	@Autowired
	private IOrganizationDao organizationDao;
	
	@Override
	public void save(Organization organization) {
		String name = organization.getName();
		if (StringUtils.isEmpty(name)) {
			throw new DataAccessResourceFailureException("名称不能为空");
		}
		organization.setId(UUIDGeneratorUtil.getUUID());
		organization.setCreateTime(new Date());
		
		int count = organizationDao.save(organization);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据保存失败");
		}
	}

	@Override
	public void saveBatch(List<Organization> organizations) {
		Organization organization = null;
		for (int i = 0; i < organizations.size(); i++) {
			organization = organizations.get(i);
			organization.setId(UUIDGeneratorUtil.getUUID());
			organization.setCreateTime(new Date());
			organizations.set(i, organization);
		}
		int count = organizationDao.saveBatch(organizations);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据保存失败");
		}
	}
	
	@Override
	public void update(Organization organization) {
		String name = organization.getName();
		if (StringUtils.isEmpty(name)) {
			throw new DataAccessResourceFailureException("名称不能为空");
		}
		organization.setUpdateTime(new Date());
		int count = organizationDao.update(organization);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据修改失败");
		}
	}

	@Override
	public void deleteById(String id) {
		if (!StringUtils.isEmpty(id)) {
			int count = organizationDao.deleteById(id);
			if (count == 0) {
				throw new DataAccessResourceFailureException("数据删除失败");
			}
		} else {
			throw new DataAccessResourceFailureException("数据删除失败");
		}
	}
	
	@Override
	public void deleteByIds(List<String> ids) {
		if (!CollectionUtils.isEmpty(ids)) {
			int count = organizationDao.deleteByIds(ids);
			if (count == 0) {
				throw new DataAccessResourceFailureException("数据删除失败");
			}
		} else {
			throw new DataAccessResourceFailureException("数据删除失败");
		}
	}

	@Override
	public void delete(Organization organization) {
		int count = organizationDao.delete(organization);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据删除失败");
		}
	}

	@Override
	public Organization getById(String id) {
		return organizationDao.getById(id);
	}

	@Override
	public Organization getData(Organization organization) {
		return organizationDao.getData(organization);
	}
	
	@Override
	public void saveOrUpdate(Organization organization) {
		if (StringUtils.isEmpty(organization.getId())) {
			save(organization);
		} else {
			update(organization);
		}
	}

	@Override
	public IPage<Organization> query(final OrganizationQueryParam param) {
		int page = param.getPage() <= 0 ? 1 : param.getPage();
		int rows = param.getRows() <= 0 ? 10 : param.getRows();
		return Pager.execute(new IPagination<Organization>() {

			@Override
			public int count() {
				return organizationDao.count(param);
			}

			@Override
			public List<Organization> query(int start, int end) {
				return organizationDao.query(param, start, end);
			}
		}, page, rows);
	}

	@Override
	public List<Tree> tree(OrganizationQueryParam param) {
		List<Tree> trees = null; 
		List<Organization> organizations = organizationDao.queryAll(param);
		if (!CollectionUtils.isEmpty(organizations)) {
			trees = new ArrayList<Tree>(); 
			Tree tree = null;
			Map<String, List<Tree>> map = new HashMap<String, List<Tree>>();
			
			for (Organization organization : organizations) {
				if (StringUtils.isEmpty(organization.getParentId())) {
					tree = new Tree();
					tree.setId(organization.getId());
					tree.setText(organization.getName());
					tree.setState(StateEnum.OPEN.name().toLowerCase());
					
					Map<String, String> attributes = new HashMap<String, String>();
					attributes.put("url", "organization/query");
					tree.setAttributes(attributes);
					trees.add(tree);
				} else {
					List<Tree> treeList = map.get(organization.getParentId());
					if (CollectionUtils.isEmpty(treeList)) {
						treeList = new ArrayList<Tree>();
					}
					tree = new Tree();
					tree.setId(organization.getId());
					tree.setText(organization.getName());
					treeList.add(tree);
				}
			}
			
			for (Tree _tree : trees) {
				List<Tree> treeList = map.get(_tree.getId());
				if (!CollectionUtils.isEmpty(treeList)) {
					_tree.setChildren(treeList);
				}
			}
		}
		return trees;
	}
}
