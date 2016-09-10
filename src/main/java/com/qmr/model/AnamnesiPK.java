package com.qmr.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Embeddable
public class AnamnesiPK implements Serializable {
	@OneToOne
	@JoinColumns({
		@JoinColumn(name="ID",referencedColumnName="ID"),
		@JoinColumn(name="IDPaz",referencedColumnName="IDPaz"),
		@JoinColumn(name="CFPaz",referencedColumnName="CFPaz")
	})
	@JsonBackReference
	private MedicalRecord mr;
	
	public AnamnesiPK(){}
	
	public MedicalRecord getMr() {
		return mr;
	}
	public void setMr(MedicalRecord mr) {
		this.mr = mr;
	}
}
