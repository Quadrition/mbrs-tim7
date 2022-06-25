package com.example.demo.model;



import com.example.demo.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

@Entity
@Table(name="user_table")
public class User { 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 

	
	@Column
	private String  firstName ;
   
	
	@Column
	private String  lastName ;
   
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Library  library ;
   

	public User(){}
      
	public User(Long id,String   firstName ,String   lastName ,Library   library 
		){
		this.id = id; 
		this.firstName  =  firstName ;
		this.lastName  =  lastName ;
		this.library  =  library ;
		}
      
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
     public String getFirstName(){
          return firstName;
     }
      
     public void setFirstName(String firstName){
          this.firstName = firstName;
     }
      
     public String getLastName(){
          return lastName;
     }
      
     public void setLastName(String lastName){
          this.lastName = lastName;
     }
      
     public Library getLibrary(){
          return library;
     }
      
     public void setLibrary(Library library){
          this.library = library;
     }
      

}
