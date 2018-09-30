package com.itheima.bos.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IRoleDao;
import com.itheima.bos.domain.Function;
import com.itheima.bos.domain.Role;
import com.itheima.bos.service.IRoleService;
import com.itheima.bos.utils.PageBean;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService{
	@Autowired
	private IRoleDao roleDao;

	@Override
	public void save(Role role, String functionIds) {
		roleDao.save(role);
		if(StringUtils.isNotBlank(functionIds)) {
			String[] function_ids = functionIds.split(",");
			for (String functionId : function_ids) {
				role.getFunctions().add(new Function(functionId));
			}
		}
	}

	@Override
	public void pqgeQuery(PageBean<Role> pageBean) {
		roleDao.pageQuery(pageBean);	
	}

	@Override
	public List<Role> findAll() {
		return roleDao.findAll();
	}

}
