package uns.ftn.mbrs.service;

import java.util.List;
import java.util.Date;

public interface BookService {

	Book findOne(Long id);
	
	List<Book> findAll();
	
	List<Book> findByTitle(String title);
	List<Book> findByYear(int year);
	List<Book> findByAgeRecommendation(Age ageRecommendation);

	Book save(BookDTO book);
	Book update(BookDTO book);
}