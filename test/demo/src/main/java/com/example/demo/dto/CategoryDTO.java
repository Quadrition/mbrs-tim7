package com.example.demo.dto;

import java.util.Date;

import java.util.ArrayList; 



import com.example.demo.model.*;


public class CategoryDTO{
	private Long id;
	  	 private String  name;
		
	  	 private String  description;
		
	
	
	
	public CategoryDTO(){}
	public CategoryDTO(Long id, String name,String description){
		this.id = id;
			this.name   = name  ;
			this.description   = description  ;
		}
	
	
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	    public String  getName (){
	           return name ;
	    }
	      
	    public void setName (String  name ){
	           this.name  = name ;
	    }
	    	
	      
	     
	    public String  getDescription (){
	           return description ;
	    }
	      
	    public void setDescription (String  description ){
	           this.description  = description ;
	    }
	    	
	      
	     

}