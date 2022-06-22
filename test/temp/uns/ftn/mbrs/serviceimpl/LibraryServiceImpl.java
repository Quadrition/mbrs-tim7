package uns.ftn.mbrs.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@Service
public class LibraryServiceImpl implements LibraryService{

	@Autowired
	private LibraryRepository libraryRepository;
	
	@Autowired
	private BookRepository bookReposiroty;
	
	@Autowired
	private UserRepository userReposiroty;
	
	@Override
	public Library findOne(Long id){
		return libraryRepository.findById(id);
	}
	
	@Override
	List<Library> findAll(){
		return libraryRepository.findAll();
	}
	
	@Override
	List<Library> findByName(String name){
		return libraryRepository.findByName(name);
	}

}