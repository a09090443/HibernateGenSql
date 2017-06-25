package com.localhost.model;
// Generated 2017/6/17 下午 08:56:49 by Hibernate Tools 5.2.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserMappingRolesId generated by hbm2java
 */
@Embeddable
public class UserMappingRolesId implements java.io.Serializable {

	private String loginId;
	private String roleId;

	public UserMappingRolesId() {
	}

	public UserMappingRolesId(String loginId, String roleId) {
		this.loginId = loginId;
		this.roleId = roleId;
	}

	@Column(name = "login_id", nullable = false, length = 6)
	public String getLoginId() {
		return this.loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	@Column(name = "role_id", nullable = false, length = 2)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserMappingRolesId))
			return false;
		UserMappingRolesId castOther = (UserMappingRolesId) other;

		return ((this.getLoginId() == castOther.getLoginId()) || (this.getLoginId() != null
				&& castOther.getLoginId() != null && this.getLoginId().equals(castOther.getLoginId())))
				&& ((this.getRoleId() == castOther.getRoleId()) || (this.getRoleId() != null
						&& castOther.getRoleId() != null && this.getRoleId().equals(castOther.getRoleId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getLoginId() == null ? 0 : this.getLoginId().hashCode());
		result = 37 * result + (getRoleId() == null ? 0 : this.getRoleId().hashCode());
		return result;
	}

}
