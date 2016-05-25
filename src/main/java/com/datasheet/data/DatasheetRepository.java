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

@Repository("datasheetRepository")
public class DatasheetRepository implements DatasheetDAO {
	
	@Autowired
	private MongoOperations mongoOps;
	
	public List<Datasheet> getAll(String username) {
		return mongoOps.findAll(Datasheet.class, 
				                mongoOps.getCollection(username).getName());
	}

	public Datasheet save(Datasheet datasheet, String username) {
		Datasheet _datasheetUpdate = findByName(datasheet.getName(), mongoOps.getCollection(username).getName());
		if(null==_datasheetUpdate){
			mongoOps.insert(datasheet, mongoOps.getCollection(username).getName());
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
			
			mongoOps.updateFirst(query, update, Datasheet.class, mongoOps.getCollection(username).getName());
			datasheet = findById(datasheet.getDatasheetId(), username);
		}
		return datasheet;
	}

	public void removeByName(String name, String username) {
		Query query = query(where("name").is(name));
		
		mongoOps.remove(query, Datasheet.class, mongoOps.getCollection(username).getName());
	}

	public void removeById(String id, String username) {
		Query query = query(where("name").is("IC1"));
		
		mongoOps.remove(query, Datasheet.class, mongoOps.getCollection(username).getName());
	}

	public Datasheet findById(String id, String username) {
		Query query = query(where("_id").is(id));
		
		Datasheet d = mongoOps.findOne(query, Datasheet.class, mongoOps.getCollection(username).getName());
		
		return d;
	}
	
	public Datasheet findByName(String name, String username) {
		Query query = query(where("name").is(name));
		
		Datasheet d = mongoOps.findOne(query, Datasheet.class, mongoOps.getCollection(username).getName());
		
		return d;
	}
}
