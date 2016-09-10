package com.qmr.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="terapia")
public class Terapia {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	
	@Column(name="data_inizio")
	private Date dataInizio;
	
	@Column(name="data_fine")
	private Date dataFine;
	
	@Column(name="stato")
	private boolean stato;
	
	@Column(name="descrizione")
	private String descrizione;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="IDmr", referencedColumnName = "ID"),
		@JoinColumn(name="IDPaz", referencedColumnName = "IDPaz"),
		@JoinColumn(name="CFPaz", referencedColumnName = "CFPaz")
	})
	@JsonBackReference
	private MedicalRecord mr;

	public MedicalRecord getMr() {
		return mr;
	}

	public void setMr(MedicalRecord mr) {
		this.mr = mr;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public boolean isStato() {
		return stato;
	}

	public void setStato(boolean stato) {
		this.stato = stato;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
}
