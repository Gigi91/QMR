package com.qmr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class PazientePK implements Serializable{
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected int ID;
	
	@Column(name="CF", unique = true)
	protected String CF;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CF == null) ? 0 : CF.hashCode());
		result = prime * result + ID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PazientePK other = (PazientePK) obj;
		if (CF == null) {
			if (other.CF != null)
				return false;
		} else if (!CF.equals(other.CF))
			return false;
		if (ID != other.ID)
			return false;
		return true;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCF() {
		return CF;
	}

	public void setCF(String cF) {
		CF = cF;
	}
}