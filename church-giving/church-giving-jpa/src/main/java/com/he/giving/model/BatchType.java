package com.he.giving.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the BatchType database table.
 * 
 */
@Entity
@NamedQuery(name="BatchType.findAll", query="SELECT b FROM BatchType b")
public class BatchType extends BasicEntity implements Serializable {

	private static final long serialVersionUID = 8146623443895256834L;

	@Id
	@SequenceGenerator(name="BATCHTYPE_ID_GENERATOR", sequenceName="BATCHTYPE.ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BATCHTYPE_ID_GENERATOR")
	private int id;

	private String description;

	public BatchType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}