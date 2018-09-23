package com.itheima.bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IFunctionDao;
import com.itheima.bos.domain.Function;
import com.itheima.bos.service.IFunctionService;
import com.itheima.bos.utils.PageBean;
@Service
@Transactional
public class FunctionServiceImpl implements IFunctionService {
    @Autowired
	private IFunctionDao functionDao; 
	@Override
	public List<Function> findAll() {
		return functionDao.findAll();
	}
	@Override
	public void save(Function model) {
		Function parentFunction = model.getParentFunction();
		if(parentFunction != null && parentFunction.getId().equals("")) {
			model.setParentFunction(null);
		}
		functionDao.save(model);
		
	}
	@Override
	public void pageQuery(PageBean<Function> pageBean) {
		functionDao.pageQuery(pageBean);
	}

}
