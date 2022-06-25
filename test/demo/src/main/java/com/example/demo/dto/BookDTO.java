package com.example.demo.dto;

import java.util.Date;

import java.util.ArrayList; 



import com.example.demo.model.*;


public class BookDTO{
	private Long id;
	     private LibraryDTO  library ;
		
	     private CategoryDTO  category ;
		
	     private ArrayList<ReviewDTO>  reviews  = new ArrayList<ReviewDTO>();
		
	  	 private String  title;
		
	  	 private int  year;
		
	  	 private Age  ageRecommendation;
		
	
	
	
	public BookDTO(){}
	public BookDTO(Long id, LibraryDTO  library,CategoryDTO  category,ArrayList<ReviewDTO> reviews ,String title,int year,Age ageRecommendation){
		this.id = id;
			this.library   = library  ;
			this.category   = category  ;
			this.reviews   =  reviews  ;
			this.title   = title  ;
			this.year   = year  ;
			this.ageRecommendation   = ageRecommendation  ;
		}
	
	
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	    public LibraryDTO getLibrary (){
	           return library ;
	    }
	      
	    public void setLibrary (LibraryDTO  library ){
	           this.library  = library ;
	    }
	    
	      
	     
	    public CategoryDTO getCategory (){
	           return category ;
	    }
	      
	    public void setCategory (CategoryDTO  category ){
	           this.category  = category ;
	    }
	    
	      
	     
	     public ArrayList<ReviewDTO> getReviews(){
	           return  reviews ;
	    }
	      
	    public void setReviews ( ArrayList<ReviewDTO>  reviews ){
	           this.reviews  = reviews ;
	    }
	    public String  getTitle (){
	           return title ;
	    }
	      
	    public void setTitle (String  title ){
	           this.title  = title ;
	    }
	    	
	      
	     
	    public int  getYear (){
	           return year ;
	    }
	      
	    public void setYear (int  year ){
	           this.year  = year ;
	    }
	    	
	      
	     
	    public Age  getAgeRecommendation (){
	           return ageRecommendation ;
	    }
	      
	    public void setAgeRecommendation (Age  ageRecommendation ){
	           this.ageRecommendation  = ageRecommendation ;
	    }
	    	
	      
	     

}