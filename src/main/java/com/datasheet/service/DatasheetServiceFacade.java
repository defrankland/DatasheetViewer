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
	
	public List<Datasheet> getAllDatasheets(String username){
		return datasheetDAO.getAll(username);
	}
	
	public Datasheet saveDatasheet(Datasheet datasheet, String username) {
		return datasheetDAO.save(datasheet, username);
	}

	public void removeDatasheetById(String id, String username) {
		datasheetDAO.removeById(id, username);
	}

	public Datasheet findDatasheetById(String id, String username){
		return datasheetDAO.findById(id, username);
	}
	
	public boolean updateLocationFromDatasheetId(String datasheetId, String location, String username) {
		Datasheet datasheet = datasheetDAO.findById(datasheetId, username);
		if(null == datasheet)
			return false;
		datasheet.setLocation(location);
		saveDatasheet(datasheet, username);		
		return true;
	}

	public void removeDatasheetByName(String name, String username) {
		datasheetDAO.removeByName(name, username);	
	}
}
