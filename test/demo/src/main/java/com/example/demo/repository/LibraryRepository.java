package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;




import com.example.demo.model.*;



@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

	
	List<Library> findByName(String  name);
	
		
	
		
}