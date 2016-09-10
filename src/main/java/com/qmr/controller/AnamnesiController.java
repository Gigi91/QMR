package com.qmr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qmr.dao.AnamnesiDAO;

@RestController
public class AnamnesiController {
	@Autowired
    @Qualifier("myAnamnesiDao")
	AnamnesiDAO anamnesiDao;

	public void setAnamnesiDao(AnamnesiDAO anamnesiDao) {
		this.anamnesiDao = anamnesiDao;
	}
	
	@RequestMapping(value = "/anamnesi", method=RequestMethod.POST)
	public void anamnesi(
			@RequestParam(value="cf") String cf,
			@RequestParam(value="allergie") String allergie,
			@RequestParam(value="malattiePregresse") String malattiePregresse,
			@RequestParam(value="malattieInfanzia") String malattieInfanzia,
			@RequestParam(value="intolleranze") String Intolleranze,
			@RequestParam(value="interventi") String Interventi,
			@RequestParam(value="vaccini") String vaccini
	){
		
		anamnesiDao.AggiungiAnamnesi(cf, allergie, malattiePregresse,
				malattieInfanzia,Intolleranze,Interventi, vaccini);
		
	}
    
	
	
}
