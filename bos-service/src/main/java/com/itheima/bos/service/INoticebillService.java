package com.itheima.bos.service;

import com.itheima.bos.domain.Noticebill;
/**
 * 业务工作单service
 * @author 38295
 *
 */
public interface INoticebillService {
	/**
	 * 保存业务工作单，并且尝试自动分单
	 * @param noticebill
	 */
    void saveNoticebill(Noticebill noticebill);
}
