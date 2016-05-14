package com.datasheet.service;

import java.util.List;

import com.datasheet.model.Datasheet;


public interface DatasheetService {
	public List<Datasheet> getAllDatasheets(String username);
	public Datasheet findDatasheetById(String id, String username);
	public Datasheet saveDatasheet(Datasheet datasheet, String username);
	public void removeDatasheetById(String id, String username);
	public void removeDatasheetByName(String name, String username);
	public boolean updateLocationFromDatasheetId(String datasheetId, String location, String username);
}
