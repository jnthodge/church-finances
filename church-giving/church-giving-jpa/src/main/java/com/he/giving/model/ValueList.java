package com.he.giving.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ValueList database table.
 * 
 */
@Entity
@NamedQuery(name="ValueList.findAll", query="SELECT v FROM ValueList v")
public class ValueList extends BasicEntity implements Serializable {

	private static final long serialVersionUID = -3346444200737570368L;

	@Id
	@SequenceGenerator(name="VALUELIST_ID_GENERATOR", sequenceName="VALUELIST.ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VALUELIST_ID_GENERATOR")
	private int id;

	private String description;

	private String name;

	//bi-directional many-to-one association to Value
	@OneToMany(mappedBy="valueList")
	private List<Value> values;

	public ValueList() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Value> getValues() {
		return this.values;
	}

	public void setValues(List<Value> values) {
		this.values = values;
	}

	public Value addValue(Value value) {
		getValues().add(value);
		value.setValueList(this);

		return value;
	}

	public Value removeValue(Value value) {
		getValues().remove(value);
		value.setValueList(null);

		return value;
	}

}