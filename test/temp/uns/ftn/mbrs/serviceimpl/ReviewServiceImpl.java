package uns.ftn.mbrs.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private Myplugin.generator.fmmodel.FMType@1bfc1b88Repository myplugin.generator.fmmodel.FMType@1bfc1b88Reposiroty;
	
	@Override
	public Review findOne(Long id){
		return reviewRepository.findById(id);
	}
	
	@Override
	List<Review> findAll(){
		return reviewRepository.findAll();
	}
	
	@Override
	List<Review> findByComment(myplugin.generator.fmmodel.FMType@1a31b887 comment){
		return reviewRepository.findByComment(comment);
	}

	@Override
	Review save(ReviewDTO review){
		Review newEntity = new Review();
		newEntity.setBook(myplugin.generator.fmmodel.FMType@1bfc1b88Reposiroty.findOne(review.getBook().getId()));	
		newEntity.setComment(review.getComment());
		
		return reviewRepository.save(newEntity);
	}
	@Override
	Review update(ReviewDTO review){
		Review existing = reviewRepository.findById(id);
		if(existing == null){
			throw new Exception("Review doesn't exist");
		}
		//update entity
		existing.setBook(myplugin.generator.fmmodel.FMType@1bfc1b88Reposiroty.findOne(review.getBook().getId()));	
		existing.setComment(review.getComment());
		
		return reviewRepository.save(existing);
	}
	@Override
	Review remove(Long id){
		Review existing = reviewRepository.findById(id);
		if(existing == null){
			throw new Exception("Review doesn't exist");
		}
		reviewRepository.delete(existing);
		
		return existing;
	}
}