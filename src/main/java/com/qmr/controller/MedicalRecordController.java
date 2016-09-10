package com.qmr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qmr.dao.MedicalRecordDAO;


@RestController
public class MedicalRecordController {
	@Autowired
    @Qualifier("myMedicalRecordDao")
    MedicalRecordDAO mrDao;

	public void setMrDao(MedicalRecordDAO mrDao) {
		this.mrDao = mrDao;
	}
	
	@RequestMapping(value = "/medicalrecord", method=RequestMethod.POST)
    public void paziente(
    		@RequestParam(value="cf") String cf,
    		@RequestParam(value="gs_tipo") String tipo,
			@RequestParam(value="gs_rh") String rh
    	) {
		
		boolean b_rh = false;
		if(rh == "1")
			b_rh = true;
		
		mrDao.addMedicalRecord(cf,tipo, b_rh);
    }
	
	
}
