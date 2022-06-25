package com.example.demo.service;

import java.util.List;
import java.util.Date;




import com.example.demo.model.*;
import com.example.demo.dto.*;

public interface LibraryService {

	Library findOne(Long id);
	
	List<Library> findAll();
	
	List<Library> findByName(String name);

	Library save(LibraryDTO library);
	Library update(LibraryDTO library) throws Exception;
	Library remove(Long id)  throws Exception;
}