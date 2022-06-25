package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;




import com.example.demo.model.*;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	List<User> findByFirstName(String  firstName);
	
		
	
	List<User> findByLastName(String  lastName);
	
		
		List<User> findByLibrary(Long id);
	
		
}