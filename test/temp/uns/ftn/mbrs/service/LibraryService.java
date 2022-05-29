package uns.ftn.mbrs.service;

import java.util.List;
import java.util.Date;

public interface LibraryService {

	Library findOne(Long id);
	
	List<Library> findAll();
	
	List<Library> findByName(myplugin.generator.fmmodel.FMType@6fb8ef53 name);

	Library save(LibraryDTO library);
	Library update(LibraryDTO library);
	Library remove(Long id);
}