package com.example.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;




import com.example.demo.model.*;
import com.example.demo.service.*;
import com.example.demo.mapper.*;
import com.example.demo.dto.*;
import com.example.demo.repository.*;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private BookRepository bookReposiroty;
	
	@Override
	public Review findOne(Long id){
		return reviewRepository.findById(id).orElse(null);
	}
	
	@Override
	public List<Review> findAll(){
		return reviewRepository.findAll();
	}
	
	@Override
	public List<Review> findByComment(String comment){
		return reviewRepository.findByComment(comment);
	}

	@Override
	public Review save(ReviewDTO review){
		Review newEntity = new Review();
		newEntity.setBook(bookReposiroty.findById(review.getBook().getId()).orElse(null));	
		newEntity.setComment(review.getComment());
		
		return reviewRepository.save(newEntity);
	}
	@Override
	public Review update(ReviewDTO review) throws Exception{
		Review existing = reviewRepository.findById(review.getId()).orElse(null);
		if(existing == null){
			throw new Exception("Review doesn't exist");
		}
		//update entity
		existing.setBook(bookReposiroty.findById(review.getBook().getId()).orElse(null));	
		existing.setComment(review.getComment());
		
		return reviewRepository.save(existing);
	}
	@Override
	public Review remove(Long id)  throws Exception{
		Review existing = reviewRepository.findById(id).orElse(null);
		if(existing == null){
			throw new Exception("Review doesn't exist");
		}
		reviewRepository.delete(existing);
		
		return existing;
	}
}