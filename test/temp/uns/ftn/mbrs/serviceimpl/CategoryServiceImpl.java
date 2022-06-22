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
	List<Category> findByName(String name){
		return categoryRepository.findByName(name);
	}
	@Override
	List<Category> findByDescription(String description){
		return categoryRepository.findByDescription(description);
	}

}