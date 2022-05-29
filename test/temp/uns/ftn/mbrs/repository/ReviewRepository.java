package uns.ftn.mbrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;
import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.model.Review;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

		List<Review> findByBook(Long id);
	
		
	
	List<Review> findByComment(String  comment);
	
		
}