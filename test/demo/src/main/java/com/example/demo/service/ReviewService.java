package com.example.demo.service;

import java.util.List;
import java.util.Date;




import com.example.demo.model.*;
import com.example.demo.dto.*;

public interface ReviewService {

	Review findOne(Long id);
	
	List<Review> findAll();
	
	List<Review> findByComment(String comment);

	Review save(ReviewDTO review);
	Review update(ReviewDTO review) throws Exception;
	Review remove(Long id)  throws Exception;
}