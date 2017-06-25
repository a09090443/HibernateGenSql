package com.localhost.model;
// Generated 2017/6/17 下午 08:56:49 by Hibernate Tools 5.2.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * UserInfo generated by hbm2java
 */
@Entity
@Table(name = "user_info", catalog = "dev_data", uniqueConstraints = @UniqueConstraint(columnNames = "login_id"))
public class UserInfo implements java.io.Serializable {

	private String userId;
	private String loginId;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	private String birthday;
	private String email;
	private String image;
	private String phone;
	private String statusId;
	private String titleId;
	private String registerTime;
	private String loginTime;
	private String status;

	public UserInfo() {
	}

	public UserInfo(String userId, String loginId, String firstName, String loginTime) {
		this.userId = userId;
		this.loginId = loginId;
		this.firstName = firstName;
		this.loginTime = loginTime;
	}

	public UserInfo(String userId, String loginId, String password, String firstName, String lastName, String address,
			String birthday, String email, String image, String phone, String statusId, String titleId,
			String registerTime, String loginTime, String status) {
		this.userId = userId;
		this.loginId = loginId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.birthday = birthday;
		this.email = email;
		this.image = image;
		this.phone = phone;
		this.statusId = statusId;
		this.titleId = titleId;
		this.registerTime = registerTime;
		this.loginTime = loginTime;
		this.status = status;
	}

	@Id

	@Column(name = "user_id", unique = true, nullable = false, length = 6)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "login_id", unique = true, nullable = false, length = 25)
	public String getLoginId() {
		return this.loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	@Column(name = "password", length = 61)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "first_name", nullable = false, length = 10)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", length = 10)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "address", length = 40)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "birthday")
	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Column(name = "email", length = 30)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "image", length = 20)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "phone", length = 11)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "status_id", length = 1)
	public String getStatusId() {
		return this.statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	@Column(name = "title_id", length = 2)
	public String getTitleId() {
		return this.titleId;
	}

	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}

	@Column(name = "registerTime")
	public String getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	@Column(name = "loginTime", nullable = false)
	public String getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	@Column(name = "status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}