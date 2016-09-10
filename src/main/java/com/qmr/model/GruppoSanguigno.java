package com.qmr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="grupposanguigno")
public class GruppoSanguigno {
	@Id
	@Column(name="ID")
	private int ID;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="Rh")
	private boolean Rh;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isRh() {
		return Rh;
	}
	public void setRh(boolean rh) {
		Rh = rh;
	}
	
}
