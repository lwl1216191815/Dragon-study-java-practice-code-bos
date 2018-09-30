package com.itheima.bos.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 定区
 */

public class Decidedzone implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Staff staff;
	private String name;
	private Set<Subarea> subareas = new HashSet<Subarea>(0);

	// Constructors

	/** default constructor */
	public Decidedzone() {
	}

	/** minimal constructor */
	public Decidedzone(String id) {
		this.id = id;
	}

	/** full constructor */
	public Decidedzone(String id, Staff staff, String name, Set<Subarea> subareas) {
		this.id = id;
		this.staff = staff;
		this.name = name;
		this.subareas = subareas;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Subarea> getSubareas() {
		return this.subareas;
	}

	public void setSubareas(Set<Subarea> subareas) {
		this.subareas = subareas;
	}

}