package com.datasheet.service;

import java.util.List;

import com.datasheet.model.Datasheet;


public interface DatasheetService {
	public List<Datasheet> getAllDatasheets();
	public Datasheet findDatasheetById(String id);
	public Datasheet saveDatasheet(Datasheet datasheet);
	public void removeDatasheetById(String id);
	public void removeDatasheetByName(String name);
	public boolean updateLocationFromDatasheetId(String datasheetId, String location);
}
