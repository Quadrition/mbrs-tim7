package com.example.demo.dto;

import java.util.Date;

import java.util.ArrayList; 



import com.example.demo.model.*;


public class ReviewDTO{
	private Long id;
	     private BookDTO  book ;
		
	  	 private String  comment;
		
	
	
	
	public ReviewDTO(){}
	public ReviewDTO(Long id, BookDTO  book,String comment){
		this.id = id;
			this.book   = book  ;
			this.comment   = comment  ;
		}
	
	
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	    public BookDTO getBook (){
	           return book ;
	    }
	      
	    public void setBook (BookDTO  book ){
	           this.book  = book ;
	    }
	    
	      
	     
	    public String  getComment (){
	           return comment ;
	    }
	      
	    public void setComment (String  comment ){
	           this.comment  = comment ;
	    }
	    	
	      
	     

}