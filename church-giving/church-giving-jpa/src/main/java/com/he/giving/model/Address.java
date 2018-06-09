package com.he.giving.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Address database table.
 * 
 */
@Entity
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address extends BasicEntity implements Serializable {

	private static final long serialVersionUID = -8995138815501122910L;

	@Id
	@SequenceGenerator(name="ADDRESS_ID_GENERATOR", sequenceName="ADDRESS.ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADDRESS_ID_GENERATOR")
	private int id;

	private byte active;

	private String city;

	private String postalCode;

	private String state;

	private String street1;

	private String street2;

	private String street3;

	//bi-directional many-to-one association to Family
	@ManyToOne
	@JoinColumn(name="FamilyID")
	private Family family;

	public Address() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet1() {
		return this.street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return this.street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getStreet3() {
		return this.street3;
	}

	public void setStreet3(String street3) {
		this.street3 = street3;
	}

	public Family getFamily() {
		return this.family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

}