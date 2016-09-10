package com.qmr.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="anamnesi")
public class Anamnesi {
	@EmbeddedId
	private AnamnesiPK anamnesiPK;
	
	@Column(name="allergie")
	private String allergie;
	
	@Column(name="MalattiePregresse")
	private String malattiePregresse;
	
	@Column(name="MalattieInfanzia")
	private String malattieInfanzia;
	
	@Column(name="Intolleranze")
	private String intolleranze;
	
	@Column(name="Interventi")
	private String interventi;
	
	@Column(name="Vaccini")
	private String vaccini;
	
	public AnamnesiPK getAnamnesiPK() {
		return anamnesiPK;
	}
	public void setAnamnesiPK(AnamnesiPK anamnesiPK) {
		this.anamnesiPK = anamnesiPK;
	}
	
	public String getAllergie() {
		return allergie;
	}
	public void setAllergie(String allergie) {
		this.allergie = allergie;
	}
	public String getMalattiePregresse() {
		return malattiePregresse;
	}
	public void setMalattiePregresse(String malattiePregresse) {
		this.malattiePregresse = malattiePregresse;
	}
	public String getMalattieInfanzia() {
		return malattieInfanzia;
	}
	public void setMalattieInfanzia(String malattieInfanzia) {
		this.malattieInfanzia = malattieInfanzia;
	}
	public String getIntolleranze() {
		return intolleranze;
	}
	public void setIntolleranze(String intolleranze) {
		this.intolleranze = intolleranze;
	}
	public String getInterventi() {
		return interventi;
	}
	public void setInterventi(String interventi) {
		this.interventi = interventi;
	}
	public String getVaccini() {
		return vaccini;
	}
	public void setVaccini(String vaccini) {
		this.vaccini = vaccini;
	}
	
	
}
