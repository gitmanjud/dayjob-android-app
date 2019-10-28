package com.example.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocationModel {

	@SerializedName("country")
	@Expose
	private String country;
	@SerializedName("state")
	@Expose
	private String state;
	@SerializedName("dist")
	@Expose
	private String dist;
	@SerializedName("tq")
	@Expose
	private String tq;
	@SerializedName("region")
	@Expose
	private String region;
	@SerializedName("desc")
	@Expose
	private String desc;

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDist() {
		return dist;
	}
	public void setDist(String dist) {
		this.dist = dist;
	}
	public String getTq() {
		return tq;
	}
	public void setTq(String tq) {
		this.tq = tq;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	@Override
	public String toString() {
		return "LocationModel [country=" + country + ", state=" + state + ", dist=" + dist + ", tq=" + tq + ", region="
				+ region + ", desc=" + desc + "]";
	}
	
	
	
}
