package com.newlecture.web.dao.java;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.newlecture.web.dao.FileDao;
import com.newlecture.web.entity.File;

@Repository
public class JavaFileDao implements FileDao {

	@Override
	public String getJSONList(String path /* 물리경로 */) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException {
		
		java.io.File directory = new java.io.File(path);
		
		
		if(!directory.exists())
			directory.mkdir();
		
		java.io.File[] files =directory.listFiles();
		
		StringBuilder json = new StringBuilder();
		json.append("[");		
		int a=1;
		for(int i=0; i<files.length; i++) {
			File f = new File(files[i]);
			json.append(f.toJSON());
			if(a < files.length)
				json.append(",");
			a++;
		}
		json.append("]");
		return json.toString();
	}

	@Override
	   public List<File> getList(String path){
	      java.io.File directory = new java.io.File(path);
	      
	      if(!directory.exists())
	         directory.mkdir();
	      
	      
	      java.io.File[] files = directory.listFiles();

	      List<File> list = new ArrayList<>();
	   
	      for(java.io.File file : files)
	         list.add(new File(file));


	      return list;
	   }
	
}
