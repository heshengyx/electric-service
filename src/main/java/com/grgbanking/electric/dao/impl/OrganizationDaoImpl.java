package com.grgbanking.electric.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.electric.dao.IOrganizationDao;
import com.grgbanking.electric.entity.Organization;
import com.grgbanking.electric.mapper.IOrganizationMapper;
import com.grgbanking.electric.param.OrganizationQueryParam;

@Repository
public class OrganizationDaoImpl implements IOrganizationDao {

	@Autowired
	private IOrganizationMapper organizationMapper;
	
	@Override
	public int save(Organization organization) {
		return organizationMapper.save(organization);
	}

	@Override
	public int saveBatch(List<Organization> organizations) {
		return organizationMapper.saveBatch(organizations);
	}
	
	@Override
	public int update(Organization organization) {
		return organizationMapper.update(organization);
	}

	@Override
	public int deleteById(String id) {
		return organizationMapper.deleteById(id);
	}

	@Override
	public int delete(Organization organization) {
		return organizationMapper.delete(organization);
	}
	
	@Override
	public int deleteByIds(List<String> ids) {
		return organizationMapper.deleteByIds(ids);
	}

	@Override
	public Organization getById(String id) {
		return organizationMapper.getById(id);
	}

	@Override
	public Organization getData(Organization organization) {
		return organizationMapper.getData(organization);
	}

	@Override
	public int count(OrganizationQueryParam param) {
		return organizationMapper.count(param);
	}

	@Override
	public List<Organization> query(OrganizationQueryParam param, int start,
			int end) {
		return organizationMapper.query(param, start, end);
	}

	@Override
	public List<Organization> queryAll(OrganizationQueryParam param) {
		return organizationMapper.queryAll(param);
	}
}
