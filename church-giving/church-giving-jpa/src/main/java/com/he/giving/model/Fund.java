package com.he.giving.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Fund database table.
 * 
 */
@Entity
@NamedQuery(name="Fund.findAll", query="SELECT f FROM Fund f")
public class Fund extends BasicEntity implements Serializable {

	private static final long serialVersionUID = -1056642751663070910L;

	@Id
	@SequenceGenerator(name="FUND_ID_GENERATOR", sequenceName="FUND.ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FUND_ID_GENERATOR")
	private int id;

	private String description;

	//bi-directional many-to-one association to Contribution
	@OneToMany(mappedBy="fund")
	private List<Contribution> contributions;

	public Fund() {
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

	public List<Contribution> getContributions() {
		return this.contributions;
	}

	public void setContributions(List<Contribution> contributions) {
		this.contributions = contributions;
	}

	public Contribution addContribution(Contribution contribution) {
		getContributions().add(contribution);
		contribution.setFund(this);

		return contribution;
	}

	public Contribution removeContribution(Contribution contribution) {
		getContributions().remove(contribution);
		contribution.setFund(null);

		return contribution;
	}

}