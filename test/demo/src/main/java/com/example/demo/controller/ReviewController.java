package com.example.demo.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;



import com.example.demo.model.*;
import com.example.demo.service.*;
import com.example.demo.mapper.*;
import com.example.demo.dto.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/review")
public class ReviewController {  

	@Autowired
	private ReviewService reviewService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<ArrayList<ReviewDTO>> getReviewList () {

		List<Review> reviewList = reviewService.findAll();
	
		return new ResponseEntity<>(ReviewMapper.toDtoList(reviewList), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<ReviewDTO> getReview(@PathVariable Long id) {
		Review review = reviewService.findOne(id);
		if (review == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(ReviewMapper.toDto(review), HttpStatus.OK);
	}
	

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<ReviewDTO> add(@RequestBody @Valid ReviewDTO newReview) {

		Review savedReview = reviewService.save(newReview);

		return new ResponseEntity<>(ReviewMapper.toDto(savedReview), HttpStatus.CREATED);
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<ReviewDTO> edit(@RequestBody @Valid ReviewDTO review, @PathVariable Long id) {

		if (id != review.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Review persisted;
		try {
			persisted = reviewService.update(review);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(ReviewMapper.toDto(persisted), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<ReviewDTO> delete(@PathVariable Long id) {
		Review deleted;
		try {
			deleted = reviewService.remove(id);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		

		return new ResponseEntity<>(ReviewMapper.toDto(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/filterByComment/{value}", method = RequestMethod.GET)
	ResponseEntity<ArrayList<ReviewDTO>> getReviewListByComment(@PathVariable String  value) {

		List<Review> reviewList = reviewService.findByComment(value);
			
		return new ResponseEntity<>(ReviewMapper.toDtoList(reviewList), HttpStatus.OK);
	}

}