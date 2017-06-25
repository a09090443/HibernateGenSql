package com.localhost.model;
// Generated 2017/6/17 下午 08:56:49 by Hibernate Tools 5.2.1.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * MemberMappingEvent generated by hbm2java
 */
@Entity
@Table(name = "member_mapping_event", catalog = "dev_data")
public class MemberMappingEvent implements java.io.Serializable {

	private MemberMappingEventId id;
	private String courseId;

	public MemberMappingEvent() {
	}

	public MemberMappingEvent(MemberMappingEventId id, String courseId) {
		this.id = id;
		this.courseId = courseId;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "eventId", column = @Column(name = "event_id", nullable = false, length = 8)),
			@AttributeOverride(name = "memberId", column = @Column(name = "member_id", nullable = false, length = 6)) })
	public MemberMappingEventId getId() {
		return this.id;
	}

	public void setId(MemberMappingEventId id) {
		this.id = id;
	}

	@Column(name = "course_id", nullable = false, length = 10)
	public String getCourseId() {
		return this.courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

}
