package com.example.demo.model;



import com.example.demo.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

@Entity
@Table(name="review_table")
public class Review { 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 

	
	@Column
	private String  comment ;
   

	public Review(){}
      
	public Review(Long id,String   comment 
		){
		this.id = id; 
		this.comment  =  comment ;
		}
      
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
     public String getComment(){
          return comment;
     }
      
     public void setComment(String comment){
          this.comment = comment;
     }
      

}
