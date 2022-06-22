package uns.ftn.mbrs.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private LibraryRepository libraryReposiroty;
	
	@Autowired
	private CategoryRepository categoryReposiroty;
	
	@Autowired
	private ReviewRepository reviewReposiroty;
	
	@Override
	public Book findOne(Long id){
		return bookRepository.findById(id);
	}
	
	@Override
	List<Book> findAll(){
		return bookRepository.findAll();
	}
	
	@Override
	List<Book> findByTitle(String title){
		return bookRepository.findByTitle(title);
	}
	@Override
	List<Book> findByYear(int year){
		return bookRepository.findByYear(year);
	}
	@Override
	List<Book> findByAgeRecommendation(Age ageRecommendation){
		return bookRepository.findByAgeRecommendation(ageRecommendation);
	}

	@Override
	Book save(BookDTO book){
		Book newEntity = new Book();
		newEntity.setLibrary(libraryReposiroty.findOne(book.getLibrary().getId()));	
		newEntity.setCategory(categoryReposiroty.findOne(book.getCategory().getId()));	
		// asocijacija reviewReposiroty		
		newEntity.setTitle(book.getTitle());
		newEntity.setYear(book.getYear());
		newEntity.setAgeRecommendation(book.getAgeRecommendation());
		
		return bookRepository.save(newEntity);
	}
	@Override
	Book update(BookDTO book){
		Book existing = bookRepository.findById(id);
		if(existing == null){
			throw new Exception("Book doesn't exist");
		}
		//update entity
		existing.setLibrary(libraryReposiroty.findOne(book.getLibrary().getId()));	
		existing.setCategory(categoryReposiroty.findOne(book.getCategory().getId()));	
		// asocijacija reviewRepository				
		existing.setTitle(book.getTitle());
		existing.setYear(book.getYear());
		existing.setAgeRecommendation(book.getAgeRecommendation());
		
		return bookRepository.save(existing);
	}
}