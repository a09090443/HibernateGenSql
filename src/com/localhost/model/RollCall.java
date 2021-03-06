package com.localhost.model;
// Generated 2017/6/17 下午 08:56:49 by Hibernate Tools 5.2.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RollCall generated by hbm2java
 */
@Entity
@Table(name = "roll_call", catalog = "dev_data")
public class RollCall implements java.io.Serializable {

	private Long rollCallId;
	private String eventId;
	private String memberId;
	private byte signIn;
	private String remark;
	private String paymentStatusId;

	public RollCall() {
	}

	public RollCall(String eventId, String memberId, byte signIn) {
		this.eventId = eventId;
		this.memberId = memberId;
		this.signIn = signIn;
	}

	public RollCall(String eventId, String memberId, byte signIn, String remark, String paymentStatusId) {
		this.eventId = eventId;
		this.memberId = memberId;
		this.signIn = signIn;
		this.remark = remark;
		this.paymentStatusId = paymentStatusId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "roll_call_id", unique = true, nullable = false)
	public Long getRollCallId() {
		return this.rollCallId;
	}

	public void setRollCallId(Long rollCallId) {
		this.rollCallId = rollCallId;
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

	@Column(name = "sign_in", nullable = false)
	public byte getSignIn() {
		return this.signIn;
	}

	public void setSignIn(byte signIn) {
		this.signIn = signIn;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "payment_status_id", length = 1)
	public String getPaymentStatusId() {
		return this.paymentStatusId;
	}

	public void setPaymentStatusId(String paymentStatusId) {
		this.paymentStatusId = paymentStatusId;
	}

}
