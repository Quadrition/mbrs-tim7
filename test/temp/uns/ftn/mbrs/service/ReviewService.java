package uns.ftn.mbrs.service;

import java.util.List;
import java.util.Date;

public interface ReviewService {

	Review findOne(Long id);
	
	List<Review> findAll();
	
	List<Review> findByComment(myplugin.generator.fmmodel.FMType@38a1210 comment);

	Review save(ReviewDTO review);
	Review update(ReviewDTO review);
	Review remove(Long id);
}