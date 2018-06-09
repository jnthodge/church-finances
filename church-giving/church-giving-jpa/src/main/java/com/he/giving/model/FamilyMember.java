package com.he.giving.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the FamilyMember database table.
 * 
 */
@Entity
@NamedQuery(name="FamilyMember.findAll", query="SELECT f FROM FamilyMember f")
public class FamilyMember extends BasicEntity implements Serializable {

	private static final long serialVersionUID = -4009708115341972175L;

	@Id
	@SequenceGenerator(name="FAMILYMEMBER_ID_GENERATOR", sequenceName="FAMILYMEMBER.ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FAMILYMEMBER_ID_GENERATOR")
	private int id;

	private byte active;

	@Temporal(TemporalType.DATE)
	private Date associationDate;

	//bi-directional many-to-one association to Family
	@ManyToOne
	@JoinColumn(name="FamilyID")
	private Family family;

	//bi-directional many-to-one association to Member
	@ManyToOne
	@JoinColumn(name="MemberID")
	private Member member;

	public FamilyMember() {
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

	public Date getAssociationDate() {
		return this.associationDate;
	}

	public void setAssociationDate(Date associationDate) {
		this.associationDate = associationDate;
	}

	public Family getFamily() {
		return this.family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}