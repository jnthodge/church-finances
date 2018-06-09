package com.he.giving.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ContributionBatch database table.
 * 
 */
@Entity
@NamedQuery(name="ContributionBatch.findAll", query="SELECT c FROM ContributionBatch c")
public class ContributionBatch extends BasicEntity implements Serializable {

	private static final long serialVersionUID = -4142792235903297163L;

	@Id
	@SequenceGenerator(name="CONTRIBUTIONBATCH_ID_GENERATOR", sequenceName="CONTRIBUTIONBATCH.ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTRIBUTIONBATCH_ID_GENERATOR")
	private int id;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String description;

	@Lob
	private String note;

	//bi-directional many-to-one association to Contribution
	@OneToMany(mappedBy="contributionBatch")
	private List<Contribution> contributions;

	public ContributionBatch() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<Contribution> getContributions() {
		return this.contributions;
	}

	public void setContributions(List<Contribution> contributions) {
		this.contributions = contributions;
	}

	public Contribution addContribution(Contribution contribution) {
		getContributions().add(contribution);
		contribution.setContributionBatch(this);

		return contribution;
	}

	public Contribution removeContribution(Contribution contribution) {
		getContributions().remove(contribution);
		contribution.setContributionBatch(null);

		return contribution;
	}

}