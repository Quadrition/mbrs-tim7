package com.example.demo.dto;

import java.util.Date;

import java.util.ArrayList; 



import com.example.demo.model.*;


public class ReviewDTO{
	private Long id;
	  	 private String  comment;
		
	
	
	
	public ReviewDTO(){}
	public ReviewDTO(Long id, String comment){
		this.id = id;
			this.comment   = comment  ;
		}
	
	
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	    public String  getComment (){
	           return comment ;
	    }
	      
	    public void setComment (String  comment ){
	           this.comment  = comment ;
	    }
	    	
	      
	     

}