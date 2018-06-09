package com.he.giving.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Contribution database table.
 * 
 */
@Entity
@NamedQuery(name="Contribution.findAll", query="SELECT c FROM Contribution c")
public class Contribution extends BasicEntity implements Serializable {

	private static final long serialVersionUID = 8843072323094150144L;

	@Id
	@SequenceGenerator(name="CONTRIBUTION_ID_GENERATOR", sequenceName="CONTRIBUTION.ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTRIBUTION_ID_GENERATOR")
	private int id;

	private String checkNo;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String envelopeNo;

	private int memberID;

	private String type;

	//bi-directional many-to-one association to ContributionBatch
	@ManyToOne
	@JoinColumn(name="BatchID")
	private ContributionBatch contributionBatch;

	//bi-directional many-to-one association to Fund
	@ManyToOne
	@JoinColumn(name="FundID")
	private Fund fund;

	public Contribution() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCheckNo() {
		return this.checkNo;
	}

	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEnvelopeNo() {
		return this.envelopeNo;
	}

	public void setEnvelopeNo(String envelopeNo) {
		this.envelopeNo = envelopeNo;
	}

	public int getMemberID() {
		return this.memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ContributionBatch getContributionBatch() {
		return this.contributionBatch;
	}

	public void setContributionBatch(ContributionBatch contributionBatch) {
		this.contributionBatch = contributionBatch;
	}

	public Fund getFund() {
		return this.fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

}