package uns.ftn.mbrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;
import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.model.Library;


@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

	
	List<Library> findByName(String  name);
	
		
	
		
	
		
}