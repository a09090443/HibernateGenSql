package com.localhost.model;
// Generated 2017/6/17 下午 08:56:49 by Hibernate Tools 5.2.1.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * UserMappingRoles generated by hbm2java
 */
@Entity
@Table(name = "user_mapping_roles", catalog = "dev_data")
public class UserMappingRoles implements java.io.Serializable {

	private UserMappingRolesId id;

	public UserMappingRoles() {
	}

	public UserMappingRoles(UserMappingRolesId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "loginId", column = @Column(name = "login_id", nullable = false, length = 6)),
			@AttributeOverride(name = "roleId", column = @Column(name = "role_id", nullable = false, length = 2)) })
	public UserMappingRolesId getId() {
		return this.id;
	}

	public void setId(UserMappingRolesId id) {
		this.id = id;
	}

}
