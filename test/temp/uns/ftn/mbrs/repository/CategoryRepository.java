package uns.ftn.mbrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;
import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.model.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	
	List<Category> findByName(String  name);
	
		
	
	List<Category> findByDescription(String  description);
	
		
}