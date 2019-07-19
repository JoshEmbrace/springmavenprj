package com.newlecture.web.entity;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

public class File {
	private boolean isFile;
	private String name;
	private String type;
	private long size;
	private Date creatDate;
	
	public File(java.io.File file) {
		name = file.getName();
		size = file.length();
	
		if(file.isDirectory())
			type="dir";
		else if(name.lastIndexOf(".")==-1)
			type="noext";
		else			
			type = name.substring(name.lastIndexOf(".")+1);
		
		//creatDate = file.toPath()
		
		try {
			BasicFileAttributes fattr
				= Files.readAttributes(file.toPath(), BasicFileAttributes.class);
			creatDate = new Date(fattr.creationTime().toMillis());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fromFile(java.io.File file) {
		name = file.getName();
	}
/*	
	public String toJSON() {
		
		//return String.format("{\"name\":\"%s\", \"type\":\"%s\", \"size\":%d, \"createDate\":\"%s\"}"
		//		, name, type, size, creatDate);
		
		StringBuilder json = new StringBuilder();
		json.append("{");
		json.append(String.format("\"name\":%s,", name));
		json.append(String.format("\"type\":\"%s\",", type));
		json.append(String.format("\"size\":\"%d\",", size));
		json.append(String.format("\"createDate\":\"%s\"", creatDate));
		json.append("}");
		
		return json.toString();
	}
*/	
	public String toJSON() throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException {
		
		return JSONParser.toJSON(this); 
	}
	
	public boolean getIsFile() {
		return isFile;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public Date getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}

	@Override
	public String toString() {
		return "File [name=" + name + ", type=" + type + ", size=" + size + ", creatDate=" + creatDate + "]";
	}
	
	
}
