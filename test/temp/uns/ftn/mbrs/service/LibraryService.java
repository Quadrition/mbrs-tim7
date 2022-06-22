package uns.ftn.mbrs.service;

import java.util.List;
import java.util.Date;

public interface LibraryService {

	Library findOne(Long id);
	
	List<Library> findAll();
	
	List<Library> findByName(String name);

}