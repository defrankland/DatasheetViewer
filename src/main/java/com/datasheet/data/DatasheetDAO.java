package com.datasheet.data;

import java.util.List;
import com.datasheet.model.Datasheet;

public interface DatasheetDAO {

	public List<Datasheet> getAll();
	public Datasheet save(Datasheet datasheet);
	public Datasheet findById(String id);
	public Datasheet findByName(String name);
	public void removeByName(String name);
	public void removeById(String id);
}
