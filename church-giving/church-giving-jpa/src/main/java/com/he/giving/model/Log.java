package com.he.giving.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Log database table.
 * 
 */
@Entity
@NamedQuery(name="Log.findAll", query="SELECT l FROM Log l")
public class Log extends BasicEntity implements Serializable {

	private static final long serialVersionUID = -4738774835361705479L;

	@Id
	@SequenceGenerator(name="LOG_ID_GENERATOR", sequenceName="LOG.ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOG_ID_GENERATOR")
	private int id;

	private String eventCode;

	@Lob
	private String eventMessage;

	private String eventType;

	public Log() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventCode() {
		return this.eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public String getEventMessage() {
		return this.eventMessage;
	}

	public void setEventMessage(String eventMessage) {
		this.eventMessage = eventMessage;
	}

	public String getEventType() {
		return this.eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

}