package com.qmr.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qmr.dao.*;
import com.qmr.model.*;



@RestController
public class PazienteController {
    @Autowired
    @Qualifier("myPazienteDao")
    PazienteDAO pazienteDao;
    
	public void setPazienteDao(PazienteDAO pazienteDao) {
		this.pazienteDao = pazienteDao;
	}

	@CrossOrigin(origins = "http://quickmedicalrecord.ns0.it")
	//@CrossOrigin(origins = "http://192.168.0.11")
	@RequestMapping(value = "/paziente", params = {"id"})
    public Object paziente(@RequestParam(value="id") int id) {
		//return pazienteDao.getPazienteById(Integer.parseInt(id));
		return pazienteDao.getPazienteById(id);
    }
	
	@CrossOrigin(origins = "http://quickmedicalrecord.ns0.it")
	//@CrossOrigin(origins = "http://192.168.0.11")
	@RequestMapping(value = "/paziente", params = {"cf"})
    public Object paziente(@RequestParam(value="cf") String cf) {
	
		return pazienteDao.getPazienteByCf(cf);
    }
	
	@RequestMapping(value = "/paziente", method=RequestMethod.POST)
	public void setPaziente(
			@RequestParam(value="cf") String cf,
			@RequestParam(value="nome") String nome,
			@RequestParam(value="cognome") String cognome,
			@RequestParam(value="dataNascita") String dataNascita,
			@RequestParam(value="indirizzo") String indirizzo,
			@RequestParam(value="paese") String paese,
			@RequestParam(value="prov") String prov,
			@RequestParam(value="sesso") String sesso,
			@RequestParam(value="email") String email,
			@RequestParam(value="telefono") String telefono
	){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date parsed = null;
		try {
			parsed = sdf.parse(dataNascita);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Paziente p = new Paziente();
		PazientePK key = new PazientePK();
		key.setCF(cf);
		p.setPazientePK(key);
		p.setCognome(cognome);
		p.setNome(nome);
		p.setDataNascita(new Date(parsed.getTime()));
		p.setIndirizzo(indirizzo);
		p.setPaese(paese);
		p.setProvincia(prov);
		p.setSesso(sesso);
		p.setEmail(email);
		p.setTelefono(telefono);
		
		pazienteDao.addPaziente(p);
	}

}