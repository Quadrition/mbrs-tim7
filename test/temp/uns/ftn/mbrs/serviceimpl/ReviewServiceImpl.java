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
	private BookRepository bookReposiroty;
	
	@Override
	public Review findOne(Long id){
		return reviewRepository.findById(id);
	}
	
	@Override
	List<Review> findAll(){
		return reviewRepository.findAll();
	}
	
	@Override
	List<Review> findByComment(String comment){
		return reviewRepository.findByComment(comment);
	}

}