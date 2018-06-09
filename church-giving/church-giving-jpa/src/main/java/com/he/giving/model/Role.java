package com.he.giving.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role extends BasicEntity implements Serializable {

	private static final long serialVersionUID = -2611447603238265537L;

	@Id
	@SequenceGenerator(name="ROLE_ID_GENERATOR", sequenceName="ROLE.ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLE_ID_GENERATOR")
	private int id;

	private String name;

	//bi-directional many-to-many association to Member
	@ManyToMany(mappedBy="roles")
	private List<Member> members;

	public Role() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Member> getMembers() {
		return this.members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

}