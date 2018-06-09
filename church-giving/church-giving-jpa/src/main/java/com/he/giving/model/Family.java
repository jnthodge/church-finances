package com.he.giving.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Family database table.
 * 
 */
@Entity
@NamedQuery(name="Family.findAll", query="SELECT f FROM Family f")
public class Family extends BasicEntity implements Serializable {

	private static final long serialVersionUID = 1822736425740330793L;

	@Id
	@SequenceGenerator(name="FAMILY_ID_GENERATOR", sequenceName="FAMILY.ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FAMILY_ID_GENERATOR")
	private int id;

	private byte active;

	private String familyName;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="family")
	private List<Address> addresses;

	//bi-directional many-to-one association to FamilyMember
	@OneToMany(mappedBy="family")
	private List<FamilyMember> familyMembers;

	public Family() {
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

	public String getFamilyName() {
		return this.familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setFamily(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setFamily(null);

		return address;
	}

	public List<FamilyMember> getFamilyMembers() {
		return this.familyMembers;
	}

	public void setFamilyMembers(List<FamilyMember> familyMembers) {
		this.familyMembers = familyMembers;
	}

	public FamilyMember addFamilyMember(FamilyMember familyMember) {
		getFamilyMembers().add(familyMember);
		familyMember.setFamily(this);

		return familyMember;
	}

	public FamilyMember removeFamilyMember(FamilyMember familyMember) {
		getFamilyMembers().remove(familyMember);
		familyMember.setFamily(null);

		return familyMember;
	}

}