package com.itheima.bos.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IDecidedzoneDao;
import com.itheima.bos.dao.INoticebillDao;
import com.itheima.bos.dao.IWorkbillDao;
import com.itheima.bos.domain.Decidedzone;
import com.itheima.bos.domain.Noticebill;
import com.itheima.bos.domain.Staff;
import com.itheima.bos.domain.User;
import com.itheima.bos.domain.Workbill;
import com.itheima.bos.service.INoticebillService;
import com.itheima.bos.utils.BOSUtils;
import com.itheima.crm.ICustomerService;

@Service
@Transactional
public class NoticebillServiceImpl implements INoticebillService {
	@Autowired
	private INoticebillDao noticebillDao;
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private IDecidedzoneDao decidedzoneDao;
	@Autowired
	private IWorkbillDao workbillDao;

	@Override
	public void saveNoticebill(Noticebill noticebill) {
		User loginUser = BOSUtils.getLoginUser();
		noticebill.setUser(loginUser);
		noticebillDao.save(noticebill);

		String pickaddress = noticebill.getPickaddress();
		String decidedzone_id = customerService.findDecidedzoneIdByAddress(pickaddress);
		if (decidedzone_id != null) {
			Decidedzone decidedzone = decidedzoneDao.findById(decidedzone_id);
			Staff staff = decidedzone.getStaff();
			noticebill.setStaff(staff);
			noticebill.setOrdertype(Noticebill.ORDERTYPE_AUTO);
			Workbill workbill = new Workbill(0, new Timestamp(System.currentTimeMillis()), noticebill, Workbill.PICKSTATE_NO,
					noticebill.getRemark(), staff, Workbill.TYPE_1);
		     System.out.println(workbill.getBuildtime());
			workbillDao.save(workbill);
			
            //
		} else {
			noticebill.setOrdertype(Noticebill.ORDERTYPE_MAN);
		}
	}

}
