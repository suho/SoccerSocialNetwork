package com.mad.hovansu.soccersocialnetwork.bean;

import java.io.Serializable;

public class District extends City implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int district_id;
	private String district_name;
	private int city_id;
	public int getDistrict_id() {
		return district_id;
	}
	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}
	public String getDistrict_name() {
		return district_name;
	}
	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

}
