package uns.ftn.mbrs.service;

import java.util.List;
import java.util.Date;

public interface ReviewService {

	Review findOne(Long id);
	
	List<Review> findAll();
	
	List<Review> findByComment(String comment);

}