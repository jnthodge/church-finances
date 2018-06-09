package com.he.giving.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LogEventTypes database table.
 * 
 */
@Entity
@Table(name="LogEventTypes")
@NamedQuery(name="LogEventType.findAll", query="SELECT l FROM LogEventType l")
public class LogEventType extends BasicEntity implements Serializable {

	private static final long serialVersionUID = -8020891991010032399L;

	@Id
	@SequenceGenerator(name="LOGEVENTTYPES_ID_GENERATOR", sequenceName="LOGEVENTTYPES.ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOGEVENTTYPES_ID_GENERATOR")
	private int id;

	private String eventType;

	public LogEventType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventType() {
		return this.eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

}