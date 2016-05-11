package com.datasheet.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

@org.springframework.data.mongodb.core.mapping.Document(collection="datasheets")
public class Datasheet {

	@Id
	private String datasheetId;
	
	private String name;
	private String location;
	
	final private String type = "pdf";
	private String description;
	private Date created;
	private Date modified;
	
	public Datasheet(){
		this(java.util.UUID.randomUUID().toString(),null);
	}
	public Datasheet(String dsId, String name){
		this(dsId,name,null,null);
	}
	public Datasheet(String documentId, String name, String location, String description){
		Date now = new Date();
		this.datasheetId = documentId;
		this.name = name;
		this.location = location;
		this.description = description;
		this.created = now;
		this.modified = now;
	}
	
	public String getDatasheetId() {
		return datasheetId;
	}

	public void setDatasheetId(String dstId) {
		this.datasheetId = dstId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String toString(){
		StringBuilder builder = new StringBuilder("Datasheet(");
		builder.append("id: ");
		builder.append(datasheetId);
		builder.append(", name: ");
		builder.append(name);
		builder.append(", type: ");
		builder.append(type);
		builder.append(", location: ");
		builder.append(location);
		builder.append(", created: ");
		builder.append(created);
		builder.append(", modified: ");
		builder.append(modified);
		builder.append(")");
		return builder.toString();
	}
}
