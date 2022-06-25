package com.example.demo.service;

import java.util.List;
import java.util.Date;




import com.example.demo.model.*;
import com.example.demo.dto.*;

public interface UserService {

	User findOne(Long id);
	
	List<User> findAll();
	
	List<User> findByFirstName(String firstName);
	List<User> findByLastName(String lastName);

	User save(UserDTO user);
	User update(UserDTO user) throws Exception;
	User remove(Long id)  throws Exception;
}