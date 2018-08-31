package com.itheima.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IWorkOrderManageDao;
import com.itheima.bos.domain.WorkOrderManage;
import com.itheima.bos.service.IWorkOrderManageService;

@Service
@Transactional
public class WorkOrderManageServiceImpl implements IWorkOrderManageService {
	@Autowired
	private IWorkOrderManageDao workOrderManageDao;

	@Override
	public void save(WorkOrderManage model) {
		workOrderManageDao.save(model);

	}

}
