package com.itheima.bos.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.ISubareaDao;
import com.itheima.bos.domain.Subarea;
import com.itheima.bos.service.ISubareaService;
import com.itheima.bos.utils.PageBean;


@Service
@Transactional
public class SubareaServiceImpl implements ISubareaService {
    
	@Autowired
	private ISubareaDao subareaDao;
	@Override
	public void save(Subarea model) {
		subareaDao.save(model);
	}
	@Override
	public void pageQuery(PageBean<Subarea> pageBean) {
		subareaDao.pageQuery(pageBean);
		
	}
	@Override
	public List<Subarea> findaAll() {
		return subareaDao.findAll();
	}
	@Override
	public List<Subarea> findUnassociatedSubareaList() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Subarea.class);
		detachedCriteria.add(Restrictions.isNull("decidedzone"));
		return subareaDao.findByCriteria(detachedCriteria);
	}
	@Override
	public List<Subarea> findSubareaListByDecidedzoneId(String decidedzoneId) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Subarea.class);
		detachedCriteria.add(Restrictions.eq("decidedzone.id", decidedzoneId));
		List<Subarea> list = subareaDao.findByCriteria(detachedCriteria );
		return list;
	}

}
