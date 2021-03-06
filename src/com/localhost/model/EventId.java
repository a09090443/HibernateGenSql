package com.localhost.model;
// Generated 2017/6/17 下午 08:56:49 by Hibernate Tools 5.2.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EventId generated by hbm2java
 */
@Embeddable
public class EventId implements java.io.Serializable {

	private String calendarId;
	private String eventId;

	public EventId() {
	}

	public EventId(String calendarId, String eventId) {
		this.calendarId = calendarId;
		this.eventId = eventId;
	}

	@Column(name = "calendar_id", nullable = false, length = 4)
	public String getCalendarId() {
		return this.calendarId;
	}

	public void setCalendarId(String calendarId) {
		this.calendarId = calendarId;
	}

	@Column(name = "event_id", nullable = false, length = 8)
	public String getEventId() {
		return this.eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EventId))
			return false;
		EventId castOther = (EventId) other;

		return ((this.getCalendarId() == castOther.getCalendarId()) || (this.getCalendarId() != null
				&& castOther.getCalendarId() != null && this.getCalendarId().equals(castOther.getCalendarId())))
				&& ((this.getEventId() == castOther.getEventId()) || (this.getEventId() != null
						&& castOther.getEventId() != null && this.getEventId().equals(castOther.getEventId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCalendarId() == null ? 0 : this.getCalendarId().hashCode());
		result = 37 * result + (getEventId() == null ? 0 : this.getEventId().hashCode());
		return result;
	}

}
