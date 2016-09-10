package com.qmr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;

@Embeddable
public class MedicalRecordPK implements Serializable {
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	
	@OneToOne
	@JoinColumns({
		@JoinColumn(name="IDPaz",referencedColumnName="ID"),
		@JoinColumn(name="CFPaz",referencedColumnName="CF")
	})
	private Paziente paziente;
	
	public MedicalRecordPK(){}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Paziente getPaziente() {
		return paziente;
	}
	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}
	

}
