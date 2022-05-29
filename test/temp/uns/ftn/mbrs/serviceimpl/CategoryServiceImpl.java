package uns.ftn.mbrs.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category findOne(Long id){
		return categoryRepository.findById(id);
	}
	
	@Override
	List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	@Override
	List<Category> findByName(myplugin.generator.fmmodel.FMType@4920437e name){
		return categoryRepository.findByName(name);
	}
	@Override
	List<Category> findByDescription(myplugin.generator.fmmodel.FMType@512d4c51 description){
		return categoryRepository.findByDescription(description);
	}

	@Override
	Category save(CategoryDTO category){
		Category newEntity = new Category();
		newEntity.setName(category.getName());
		newEntity.setDescription(category.getDescription());
		
		return categoryRepository.save(newEntity);
	}
	@Override
	Category update(CategoryDTO category){
		Category existing = categoryRepository.findById(id);
		if(existing == null){
			throw new Exception("Category doesn't exist");
		}
		//update entity
		existing.setName(category.getName());
		existing.setDescription(category.getDescription());
		
		return categoryRepository.save(existing);
	}
	@Override
	Category remove(Long id){
		Category existing = categoryRepository.findById(id);
		if(existing == null){
			throw new Exception("Category doesn't exist");
		}
		categoryRepository.delete(existing);
		
		return existing;
	}
}