package com.datasheet.data;

import java.util.List;
import com.datasheet.model.Datasheet;

public interface DatasheetDAO {

	public List<Datasheet> getAll(String username);
	public Datasheet save(Datasheet datasheet, String username);
	public Datasheet findById(String id, String username);
	public Datasheet findByName(String name, String username);
	public void removeByName(String name, String username);
	public void removeById(String id, String username);
}
