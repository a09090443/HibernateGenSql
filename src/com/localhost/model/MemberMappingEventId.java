package com.localhost.model;
// Generated 2017/6/17 下午 08:56:49 by Hibernate Tools 5.2.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * MemberMappingEventId generated by hbm2java
 */
@Embeddable
public class MemberMappingEventId implements java.io.Serializable {

	private String eventId;
	private String memberId;

	public MemberMappingEventId() {
	}

	public MemberMappingEventId(String eventId, String memberId) {
		this.eventId = eventId;
		this.memberId = memberId;
	}

	@Column(name = "event_id", nullable = false, length = 8)
	public String getEventId() {
		return this.eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	@Column(name = "member_id", nullable = false, length = 6)
	public String getMemberId() {
		return this.memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MemberMappingEventId))
			return false;
		MemberMappingEventId castOther = (MemberMappingEventId) other;

		return ((this.getEventId() == castOther.getEventId()) || (this.getEventId() != null
				&& castOther.getEventId() != null && this.getEventId().equals(castOther.getEventId())))
				&& ((this.getMemberId() == castOther.getMemberId()) || (this.getMemberId() != null
						&& castOther.getMemberId() != null && this.getMemberId().equals(castOther.getMemberId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getEventId() == null ? 0 : this.getEventId().hashCode());
		result = 37 * result + (getMemberId() == null ? 0 : this.getMemberId().hashCode());
		return result;
	}

}
