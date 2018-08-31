package com.itheima.bos.domain;

import java.sql.Timestamp;

/**
 * 工单
 */

public class Workbill implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Noticebill noticebill;
	private Staff staff;
	private String type;//工单类型:新、追、改、销
	private String pickstate;//取件状态:未取件、取件中、已取件
	private Timestamp buildtime;
	private Integer attachbilltimes;
	private String remark;

	public static final String  TYPE_1 = "新单";
	public static final String  TYPE_2 = "追单";
	public static final String  TYPE_3 = "改单";
	public static final String  TYPE_4 = "销单";
	
	public static final String  PICKSTATE_NO = "未取件";
	public static final String  PICKSTATE_RUNNING = "取件中";
	public static final String  PICKSTATE_YES = "已取件";
	

    public Workbill(Integer attachbilltimes,Timestamp buildtime,Noticebill noticebill,String pickstate,String remark,Staff staff,String type) {
    	this.remark= remark;
    	this.type = type;
    	this.attachbilltimes = attachbilltimes;
    	this.buildtime = buildtime;
    	this.noticebill = noticebill;
    	this.pickstate = pickstate;
    	this.staff = staff;
    }
	public Workbill() {
	}

	/**
	 * 微型构造器
	 * @param id
	 * @param buildtime
	 */
	public Workbill(String id, Timestamp buildtime) {
		this.id = id;
		this.buildtime = buildtime;
	}



	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Noticebill getNoticebill() {
		return this.noticebill;
	}

	public void setNoticebill(Noticebill noticebill) {
		this.noticebill = noticebill;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPickstate() {
		return this.pickstate;
	}

	public void setPickstate(String pickstate) {
		this.pickstate = pickstate;
	}

	public Timestamp getBuildtime() {
		return this.buildtime;
	}

	public void setBuildtime(Timestamp buildtime) {
		this.buildtime = buildtime;
	}

	public Integer getAttachbilltimes() {
		return this.attachbilltimes;
	}

	public void setAttachbilltimes(Integer attachbilltimes) {
		this.attachbilltimes = attachbilltimes;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}