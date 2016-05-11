package com.datasheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasheet.data.DatasheetDAO;
import com.datasheet.model.Datasheet;

@Service("datasheetFacade")
public class DatasheetServiceFacade implements DatasheetService {

	@Autowired
	DatasheetDAO datasheetDAO;
	
	public List<Datasheet> getAllDatasheets(){
		return datasheetDAO.getAll();
	}
	
	public Datasheet saveDatasheet(Datasheet datasheet) {
		return datasheetDAO.save(datasheet);
	}

	public void removeDatasheetById(String id) {
		datasheetDAO.removeById(id);
	}

	public Datasheet findDatasheetById(String id){
		return datasheetDAO.findById(id);
	}
	
	public boolean updateLocationFromDatasheetId(String datasheetId, String location) {
		Datasheet datasheet = datasheetDAO.findById(datasheetId);
		if(null == datasheet)
			return false;
		datasheet.setLocation(location);
		saveDatasheet(datasheet);		
		return true;
	}

	public void removeDatasheetByName(String name) {
		datasheetDAO.removeByName(name);	
	}
}
