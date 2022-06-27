package com.example.demo.model;



import com.example.demo.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

@Entity
@Table(name="book_table")
public class Book { 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 

	
	@ManyToOne(fetch=FetchType.LAZY)
	private Category  category ;
   
	
	@Column
	private String  title ;
   
	
	@Column
	private int  year ;
   
	
	@Column
	@Enumerated(EnumType.STRING)
	private Age  ageRecommendation ;
   
	@OneToMany
	private List<Review >  reviews  = new ArrayList<Review>();


	public Book(){}
      
	public Book(Long id,Category   category ,String   title ,int   year ,Age   ageRecommendation ,ArrayList<Review >  reviews 
		){
		this.id = id; 
		this.category  =  category ;
		this.title  =  title ;
		this.year  =  year ;
		this.ageRecommendation  =  ageRecommendation ;
		this.reviews   =  reviews  ;
		}
      
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
     public Category getCategory(){
          return category;
     }
      
     public void setCategory(Category category){
          this.category = category;
     }
      
     public String getTitle(){
          return title;
     }
      
     public void setTitle(String title){
          this.title = title;
     }
      
     public int getYear(){
          return year;
     }
      
     public void setYear(int year){
          this.year = year;
     }
      
     public Age getAgeRecommendation(){
          return ageRecommendation;
     }
      
     public void setAgeRecommendation(Age ageRecommendation){
          this.ageRecommendation = ageRecommendation;
     }
      
     public List<Review> getReviews(){
          return reviews;
     }
      
     public void setReviews(List<Review> reviews){
          this.reviews = reviews;
     }
      

}
