package uns.ftn.mbrs.service;

import java.util.List;
import java.util.Date;

public interface BookService {

	Book findOne(Long id);
	
	List<Book> findAll();
	
	List<Book> findByTitle(myplugin.generator.fmmodel.FMType@621c5822 title);
	List<Book> findByYear(myplugin.generator.fmmodel.FMType@5f45f373 year);
	List<Book> findByAgeRecommendation(myplugin.generator.fmmodel.FMType@77af4dbf ageRecommendation);

	Book save(BookDTO book);
	Book update(BookDTO book);
	Book remove(Long id);
}