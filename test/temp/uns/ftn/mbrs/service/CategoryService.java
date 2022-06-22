package uns.ftn.mbrs.service;

import java.util.List;
import java.util.Date;

public interface CategoryService {

	Category findOne(Long id);
	
	List<Category> findAll();
	
	List<Category> findByName(String name);
	List<Category> findByDescription(String description);

}