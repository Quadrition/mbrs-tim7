package com.example.demo.service;

import java.util.List;
import java.util.Date;




import com.example.demo.model.*;
import com.example.demo.dto.*;

public interface CategoryService {

	Category findOne(Long id);
	
	List<Category> findAll();
	
	List<Category> findByName(String name);
	List<Category> findByDescription(String description);

	Category save(CategoryDTO category);
	Category update(CategoryDTO category) throws Exception;
	Category remove(Long id)  throws Exception;
}