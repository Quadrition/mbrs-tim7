package uns.ftn.mbrs.controller;

import java.util.List;
import java.util.Date;
import uns.ftn.mbrs.model.*;


import uns.ftn.mbrs.model.Review;
import uns.ftn.mbrs.service.ReviewService;
import uns.ftn.mbrs.converter.ReviewDTOToReview;
import uns.ftn.mbrs.converter.ReviewToReviewDTO;
import uns.ftn.mbrs.dto.ReviewDTO;

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
	
	@Autowired
	private ReviewToReviewDTO toDTO;
	
	@Autowired
	private ReviewDTOToReview toReview;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<ReviewDTO>> getReviewList () {

		List<Review> reviewList = reviewService.findAll();
	
		return new ResponseEntity<>(toDTO.convert(reviewList), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<ReviewDTO> getReview(@PathVariable Long id) {
		Review review = reviewService.findOne(id);
		if (review == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(review), HttpStatus.OK);
	}
	

	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<ReviewDTO> add(@RequestBody @Valid ReviewDTO newReview) {

		Review savedReview = reviewService.save(toReview.convert(newReview));

		return new ResponseEntity<>(toDTO.convert(savedReview), HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<ReviewDTO> edit(@RequestBody @Valid ReviewDTO review, @PathVariable Long id) {

		if (id != review.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Review persisted = reviewService.save(toReview.convert(review));

		return new ResponseEntity<>(toDTO.convert(persisted), HttpStatus.OK);
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<ReviewDTO> delete(@PathVariable Long id) {
		Review deleted = reviewService.remove(id);

		return new ResponseEntity<>(toDTO.convert(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/filterByBookId/{id}", method = RequestMethod.GET)
	ResponseEntity<List<ReviewDTO>> getReviewListByBookId(@PathVariable Long id) {

		List<Review> reviewList = reviewService.findByBook(id);
			
		return new ResponseEntity<>(toDTO.convert(reviewList), HttpStatus.OK);
	}

	@RequestMapping(value = "/filterByComment/{value}", method = RequestMethod.GET)
	ResponseEntity<List<ReviewDTO>> getReviewListByComment(@PathVariable String  value) {

		List<Review> reviewList = reviewService.findByComment(value);
			
		return new ResponseEntity<>(toDTO.convert(reviewList), HttpStatus.OK);
	}

}