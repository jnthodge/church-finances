package com.he.giving.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Member database table.
 * 
 */
@Entity
@NamedQuery(name="Member.findAll", query="SELECT m FROM Member m")
public class Member extends BasicEntity implements Serializable {

	private static final long serialVersionUID = 5851500244290579502L;

	@Id
	@SequenceGenerator(name="MEMBER_ID_GENERATOR", sequenceName="MEMBER.ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEMBER_ID_GENERATOR")
	private int id;

	private byte active;

	private String addressID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	private String dateOfBirth;

	private String firstName;

	private int groupID;

	private String lastName;

	private String loginID;

	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	//bi-directional many-to-one association to FamilyMember
	@OneToMany(mappedBy="member")
	private List<FamilyMember> familyMembers;

	//bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(
		name="MemberRole"
		, joinColumns={
			@JoinColumn(name="MemberID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="RoleID")
			}
		)
	private List<Role> roles;

	public Member() {
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

	public String getAddressID() {
		return this.addressID;
	}

	public void setAddressID(String addressID) {
		this.addressID = addressID;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getGroupID() {
		return this.groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginID() {
		return this.loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<FamilyMember> getFamilyMembers() {
		return this.familyMembers;
	}

	public void setFamilyMembers(List<FamilyMember> familyMembers) {
		this.familyMembers = familyMembers;
	}

	public FamilyMember addFamilyMember(FamilyMember familyMember) {
		getFamilyMembers().add(familyMember);
		familyMember.setMember(this);

		return familyMember;
	}

	public FamilyMember removeFamilyMember(FamilyMember familyMember) {
		getFamilyMembers().remove(familyMember);
		familyMember.setMember(null);

		return familyMember;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}