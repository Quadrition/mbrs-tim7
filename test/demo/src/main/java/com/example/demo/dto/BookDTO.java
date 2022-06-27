package com.example.demo.dto;

import java.util.Date;

import java.util.ArrayList; 



import com.example.demo.model.*;


public class BookDTO{
	private Long id;
	     private CategoryDTO  category ;
		
	  	 private String  title;
		
	  	 private int  year;
		
	  	 private Age  ageRecommendation;
		
	     private ArrayList<ReviewDTO>  reviews  = new ArrayList<ReviewDTO>();
		
	
	
	
	public BookDTO(){}
	public BookDTO(Long id, CategoryDTO  category,String title,int year,Age ageRecommendation,ArrayList<ReviewDTO> reviews ){
		this.id = id;
			this.category   = category  ;
			this.title   = title  ;
			this.year   = year  ;
			this.ageRecommendation   = ageRecommendation  ;
			this.reviews   =  reviews  ;
		}
	
	
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	    public CategoryDTO getCategory (){
	           return category ;
	    }
	      
	    public void setCategory (CategoryDTO  category ){
	           this.category  = category ;
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
	    	
	      
	     
	     public ArrayList<ReviewDTO> getReviews(){
	           return  reviews ;
	    }
	      
	    public void setReviews ( ArrayList<ReviewDTO>  reviews ){
	           this.reviews  = reviews ;
	    }

}