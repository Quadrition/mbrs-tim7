package com.example.demo.dto;

import java.util.Date;

import java.util.ArrayList; 



import com.example.demo.model.*;


public class LibraryDTO{
	private Long id;
	  	 private String  name;
		
	     private ArrayList<BookDTO>  books  = new ArrayList<BookDTO>();
		
	     private ArrayList<UserDTO>  users  = new ArrayList<UserDTO>();
		
	
	
	
	public LibraryDTO(){}
	public LibraryDTO(Long id, String name,ArrayList<BookDTO> books ,ArrayList<UserDTO> users ){
		this.id = id;
			this.name   = name  ;
			this.books   =  books  ;
			this.users   =  users  ;
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
	    	
	      
	     
	     public ArrayList<BookDTO> getBooks(){
	           return  books ;
	    }
	      
	    public void setBooks ( ArrayList<BookDTO>  books ){
	           this.books  = books ;
	    }
	     public ArrayList<UserDTO> getUsers(){
	           return  users ;
	    }
	      
	    public void setUsers ( ArrayList<UserDTO>  users ){
	           this.users  = users ;
	    }

}