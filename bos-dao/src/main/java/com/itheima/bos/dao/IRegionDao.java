package com.itheima.bos.dao;

import java.util.List;

import com.itheima.bos.dao.base.IBaseDao;
import com.itheima.bos.domain.Region;

public interface IRegionDao extends IBaseDao<Region>{
    /**
     * 根据参数q进行模糊查询
     * @param q
     * @return
     */
	List<Region> findListByQ(String q);

}
