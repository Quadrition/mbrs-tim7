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
	private Myplugin.generator.fmmodel.FMType@7e3e56d8Repository myplugin.generator.fmmodel.FMType@7e3e56d8Reposiroty;
	
	@Autowired
	private Myplugin.generator.fmmodel.FMType@71e08391Repository myplugin.generator.fmmodel.FMType@71e08391Reposiroty;
	
	@Autowired
	private Myplugin.generator.fmmodel.FMType@cfd47fdRepository myplugin.generator.fmmodel.FMType@cfd47fdReposiroty;
	
	@Override
	public Book findOne(Long id){
		return bookRepository.findById(id);
	}
	
	@Override
	List<Book> findAll(){
		return bookRepository.findAll();
	}
	
	@Override
	List<Book> findByTitle(myplugin.generator.fmmodel.FMType@5689c388 title){
		return bookRepository.findByTitle(title);
	}
	@Override
	List<Book> findByYear(myplugin.generator.fmmodel.FMType@5a8dc717 year){
		return bookRepository.findByYear(year);
	}
	@Override
	List<Book> findByAgeRecommendation(myplugin.generator.fmmodel.FMType@2f843bdc ageRecommendation){
		return bookRepository.findByAgeRecommendation(ageRecommendation);
	}

	@Override
	Book save(BookDTO book){
		Book newEntity = new Book();
		newEntity.setLibrary(myplugin.generator.fmmodel.FMType@7e3e56d8Reposiroty.findOne(book.getLibrary().getId()));	
		newEntity.setCategory(myplugin.generator.fmmodel.FMType@71e08391Reposiroty.findOne(book.getCategory().getId()));	
		// asocijacija myplugin.generator.fmmodel.FMType@cfd47fdReposiroty		
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
		existing.setLibrary(myplugin.generator.fmmodel.FMType@7e3e56d8Reposiroty.findOne(book.getLibrary().getId()));	
		existing.setCategory(myplugin.generator.fmmodel.FMType@71e08391Reposiroty.findOne(book.getCategory().getId()));	
		// asocijacija myplugin.generator.fmmodel.FMType@cfd47fdReposiroty				
		existing.setTitle(book.getTitle());
		existing.setYear(book.getYear());
		existing.setAgeRecommendation(book.getAgeRecommendation());
		
		return bookRepository.save(existing);
	}
	@Override
	Book remove(Long id){
		Book existing = bookRepository.findById(id);
		if(existing == null){
			throw new Exception("Book doesn't exist");
		}
		bookRepository.delete(existing);
		
		return existing;
	}
}