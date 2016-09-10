package com.qmr.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="medicalrecord")
public class MedicalRecord {
	@EmbeddedId
	private MedicalRecordPK mrPK;
	
	@ManyToOne
	@JoinColumn(name="gs_ID")
	private GruppoSanguigno gs;
	
	@OneToOne(mappedBy="anamnesiPK.mr")
    private Anamnesi anamnesi;
	
	public Anamnesi getAnamnesi() {
		return anamnesi;
	}
	public void setAnamnesi(Anamnesi anamnesi) {
		this.anamnesi = anamnesi;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="mr")  
	@JsonManagedReference
	private Set<Terapia> terapie = new HashSet<Terapia>(0);
	
	public Set<Terapia> getTerapie() {
		return terapie;
	}
	public void setTerapie(Set<Terapia> terapie) {
		this.terapie = terapie;
	}
	
	public MedicalRecordPK getMrPK() {
		return mrPK;
	}
	public void setMrPK(MedicalRecordPK mrPk) {
		this.mrPK = mrPk;
	}
	public GruppoSanguigno getGs() {
		return gs;
	}
	public void setGs(GruppoSanguigno gs) {
		this.gs = gs;
	}
	
	
	
}
