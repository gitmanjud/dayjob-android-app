package com.example.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {

	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("firstName")
	@Expose
	private String firstName;
	@SerializedName("middleName")
	@Expose
	private String middleName;
	@SerializedName("lastName")
	@Expose
	private String lastName;
	@SerializedName("mobileNo")
	@Expose
	private String mobileNo;
	@SerializedName("gender")
	@Expose
	private String gender;
	@SerializedName("bdate")
	@Expose
	private String bdate;
	@SerializedName("age")
	@Expose
	private String age;
	@SerializedName("password")
	@Expose
	private String password;
	@SerializedName("created")
	@Expose
	private String created;
	@SerializedName("updated")
	@Expose
	private String updated;
	@SerializedName("email")
	@Expose
	private String email;
	@SerializedName("userId")
	@Expose
	private String userId;
	@SerializedName("active")
	@Expose
	private boolean active;
	@SerializedName("location")
	@Expose
	private LocationModel location;

	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public LocationModel getLocation() {
		return location;
	}
	public void setLocation(LocationModel location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", mobileNo=" + mobileNo + ", gender=" + gender + ", bdate="
				+ bdate + ", age=" + age + ", password=" + password + ", created=" + created + ", updated=" + updated
				+ ", email=" + email + ", userId=" + userId + ", active=" + active + ", location=" + location + "]";
	}
	
	
}
