package com.qmr.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="paziente")
public class Dottore {
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected int ID;
	
	@Column(name = "Nome")
	String Nome;
	
	@Column(name = "Cognome")
	String Cognome;
	
	@Column(name = "Sesso")
	String Sesso;
	
	@Column(name = "Indirizzo")
	String Indirizzo;
	
	@Column(name = "Paese")
	String Paese;
	
	@Column(name = "Provincia")
	String Provincia;
	
	@Column(name = "DataNascita")
	Date DataNascita;
	
	@Column(name="email", unique = true)
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Column(name="telefono", unique =true )
	private String telefono;
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	public String getSesso() {
		return Sesso;
	}
	public void setSesso(String sesso) {
		Sesso = sesso;
	}
	public String getIndirizzo() {
		return Indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		Indirizzo = indirizzo;
	}
	public String getPaese() {
		return Paese;
	}
	public void setPaese(String paese) {
		Paese = paese;
	}
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String provincia) {
		Provincia = provincia;
	}
	public Date getDataNascita() {
		return DataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		DataNascita = dataNascita;
	}

}
