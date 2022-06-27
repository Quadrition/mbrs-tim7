package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;




import com.example.demo.model.*;



@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

		List<Book> findByCategory(Long id);
	
		
	
	List<Book> findByTitle(String  title);
	
		
	
	List<Book> findByYear(int  year);
	
		
	
	List<Book> findByAgeRecommendation(Age  ageRecommendation);
	
		
	
		
}