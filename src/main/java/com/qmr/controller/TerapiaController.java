package com.qmr.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qmr.dao.TerapiaDAO;

@RestController
public class TerapiaController {
	@Autowired
    @Qualifier("myTerapiaDao")
    TerapiaDAO terapiaDao;

	public void setTerapiaDao(TerapiaDAO terapiaDao) {
		this.terapiaDao = terapiaDao;
	}
	
	@RequestMapping(value = "/terapia", method=RequestMethod.POST)
    public void terapia(
    		@RequestParam(value="cf") String cf,
    		@RequestParam(value="dataInizio") String dataInizio,
			@RequestParam(value="dataFine") String dataFine,
			@RequestParam(value="stato") Boolean stato,
			@RequestParam(value="descr") String descrizione
    	) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date dataInizioParsed = null;
		java.util.Date dataFineParsed = null;
		try {
			dataInizioParsed  = sdf.parse(dataInizio);
			dataFineParsed = sdf.parse(dataFine);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		terapiaDao.addTerapia(cf, new Date(dataInizioParsed.getTime()),
								  new Date(dataFineParsed.getTime()),
								  stato, descrizione);
		
    }

}
