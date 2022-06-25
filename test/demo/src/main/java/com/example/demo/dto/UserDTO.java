package com.example.demo.dto;

import java.util.Date;

import java.util.ArrayList; 



import com.example.demo.model.*;


public class UserDTO{
	private Long id;
	  	 private String  firstName;
		
	  	 private String  lastName;
		
	     private LibraryDTO  library ;
		
	
	
	
	public UserDTO(){}
	public UserDTO(Long id, String firstName,String lastName,LibraryDTO  library){
		this.id = id;
			this.firstName   = firstName  ;
			this.lastName   = lastName  ;
			this.library   = library  ;
		}
	
	
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	    public String  getFirstName (){
	           return firstName ;
	    }
	      
	    public void setFirstName (String  firstName ){
	           this.firstName  = firstName ;
	    }
	    	
	      
	     
	    public String  getLastName (){
	           return lastName ;
	    }
	      
	    public void setLastName (String  lastName ){
	           this.lastName  = lastName ;
	    }
	    	
	      
	     
	    public LibraryDTO getLibrary (){
	           return library ;
	    }
	      
	    public void setLibrary (LibraryDTO  library ){
	           this.library  = library ;
	    }
	    
	      
	     

}