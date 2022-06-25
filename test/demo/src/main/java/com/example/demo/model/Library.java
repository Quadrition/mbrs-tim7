package com.example.demo.model;



import com.example.demo.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

@Entity
@Table(name="library_table")
public class Library { 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 

	
	@Column
	private String  name ;
   
	@OneToMany
	private List<Book >  books  = new ArrayList<Book>();

	@OneToMany
	private List<User >  users  = new ArrayList<User>();


	public Library(){}
      
	public Library(Long id,String   name ,ArrayList<Book >  books ,ArrayList<User >  users 
		){
		this.id = id; 
		this.name  =  name ;
		this.books   =  books  ;
		this.users   =  users  ;
		}
      
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
     public String getName(){
          return name;
     }
      
     public void setName(String name){
          this.name = name;
     }
      
     public List<Book> getBooks(){
          return books;
     }
      
     public void setBooks(List<Book> books){
          this.books = books;
     }
      
     public List<User> getUsers(){
          return users;
     }
      
     public void setUsers(List<User> users){
          this.users = users;
     }
      

}
