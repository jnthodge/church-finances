package com.he.giving.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Value database table.
 * 
 */
@Entity
@NamedQuery(name="Value.findAll", query="SELECT v FROM Value v")
public class Value extends BasicEntity implements Serializable {

	private static final long serialVersionUID = 2041123654086658956L;

	@Id
	@SequenceGenerator(name="VALUE_ID_GENERATOR", sequenceName="VALUE.ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VALUE_ID_GENERATOR")
	private int id;

	private byte booleanValue;

	@Temporal(TemporalType.DATE)
	private Date dateValue;

	private int intValue;

	private String stringValue;

	@Lob
	private String textValue;

	//bi-directional many-to-one association to ValueList
	@ManyToOne
	@JoinColumn(name="ValueListID")
	private ValueList valueList;

	public Value() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getBooleanValue() {
		return this.booleanValue;
	}

	public void setBooleanValue(byte booleanValue) {
		this.booleanValue = booleanValue;
	}

	public Date getDateValue() {
		return this.dateValue;
	}

	public void setDateValue(Date dateValue) {
		this.dateValue = dateValue;
	}

	public int getIntValue() {
		return this.intValue;
	}

	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}

	public String getStringValue() {
		return this.stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public String getTextValue() {
		return this.textValue;
	}

	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}

	public ValueList getValueList() {
		return this.valueList;
	}

	public void setValueList(ValueList valueList) {
		this.valueList = valueList;
	}

}