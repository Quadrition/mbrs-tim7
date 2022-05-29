package uns.ftn.mbrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;
import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.model.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

		List<Book> findByLibrary(Long id);
	
		
		List<Book> findByCategory(Long id);
	
		
	
		
	
	List<Book> findByTitle(String  title);
	
		
	
	List<Book> findByYear(int  year);
	
		
	
	List<Book> findByAgeRecommendation(Age  ageRecommendation);
	
		
}