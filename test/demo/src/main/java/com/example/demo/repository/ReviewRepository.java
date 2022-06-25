package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;




import com.example.demo.model.*;



@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

		List<Review> findByBook(Long id);
	
		
	
	List<Review> findByComment(String  comment);
	
		
}