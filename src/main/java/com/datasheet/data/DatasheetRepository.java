package com.datasheet.data;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.datasheet.model.Datasheet;

@Repository("mongoDatasheetDAO")
public class DatasheetRepository implements DatasheetDAO {
	
	@Autowired
	private MongoOperations mongoOps;
	
	public List<Datasheet> getAll() {
		return mongoOps.findAll(Datasheet.class);
	}

	public Datasheet save(Datasheet datasheet) {
		Datasheet _datasheetUpdate = findByName(datasheet.getName());
		if(null==_datasheetUpdate){
			mongoOps.insert(datasheet);
		}else{
			Query query = query(where("_id").is(datasheet.getDatasheetId()));
			Update update = new Update();
			
			update.set("name",null == datasheet.getName() ? 
					_datasheetUpdate.getName():datasheet.getName());
			update.set("location",null == datasheet.getLocation() ? 
					_datasheetUpdate.getLocation():datasheet.getLocation());
			update.set("description",null == datasheet.getDescription() ? 
					_datasheetUpdate.getDescription() : datasheet.getDescription());
			update.set("modified", new Date());
			
			mongoOps.updateFirst(query, update, Datasheet.class);
			datasheet = findById(datasheet.getDatasheetId());
		}
		return datasheet;
	}

	public void removeByName(String name) {
		Query query = query(where("name").is(name));
		
		mongoOps.remove(query, Datasheet.class);
	}

	public void removeById(String id) {
		Query query = query(where("name").is("IC1"));
		
		mongoOps.remove(query, Datasheet.class);
	}

	public Datasheet findById(String id) {
		Query query = query(where("_id").is(id));
		
		Datasheet d = mongoOps.findOne(query, Datasheet.class);
		
		return d;
	}
	
	public Datasheet findByName(String name) {
		Query query = query(where("name").is(name));
		
		Datasheet d = mongoOps.findOne(query, Datasheet.class);
		
		return d;
	}
}
