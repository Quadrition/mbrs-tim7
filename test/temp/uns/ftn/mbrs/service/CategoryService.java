package uns.ftn.mbrs.service;

import java.util.List;
import java.util.Date;

public interface CategoryService {

	Category findOne(Long id);
	
	List<Category> findAll();
	
	List<Category> findByName(myplugin.generator.fmmodel.FMType@5b5fc261 name);
	List<Category> findByDescription(myplugin.generator.fmmodel.FMType@5b824c60 description);

	Category save(CategoryDTO category);
	Category update(CategoryDTO category);
	Category remove(Long id);
}