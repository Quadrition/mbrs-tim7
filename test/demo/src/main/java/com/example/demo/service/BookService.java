package com.example.demo.service;

import java.util.List;
import java.util.Date;




import com.example.demo.model.*;
import com.example.demo.dto.*;

public interface BookService {

	Book findOne(Long id);
	
	List<Book> findAll();
	
	List<Book> findByTitle(String title);
	List<Book> findByYear(int year);
	List<Book> findByAgeRecommendation(Age ageRecommendation);

	Book save(BookDTO book);
	Book update(BookDTO book) throws Exception;
}