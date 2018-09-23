package com.itheima.bos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itheima.bos.dao.IFunctionDao;
import com.itheima.bos.dao.base.impl.BaseDaoImpl;
import com.itheima.bos.domain.Function;
@Repository
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements IFunctionDao {

     @SuppressWarnings("unchecked")
	public List<Function> findAll(){
    	 String hql="FROM Function f WHERE f.parentFunction IS NULL";
    	 return (List<Function>) this.getHibernateTemplate().find(hql);
     }

}
