package com.example.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;




import com.example.demo.model.*;
import com.example.demo.service.*;
import com.example.demo.mapper.*;
import com.example.demo.dto.*;
import com.example.demo.repository.*;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LibraryRepository libraryReposiroty;
	
	@Override
	public User findOne(Long id){
		return userRepository.findById(id).orElse(null);
	}
	
	@Override
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	@Override
	public List<User> findByFirstName(String firstName){
		return userRepository.findByFirstName(firstName);
	}
	@Override
	public List<User> findByLastName(String lastName){
		return userRepository.findByLastName(lastName);
	}

	@Override
	public User save(UserDTO user){
		User newEntity = new User();
		newEntity.setFirstName(user.getFirstName());
		newEntity.setLastName(user.getLastName());
		newEntity.setLibrary(libraryReposiroty.findById(user.getLibrary().getId()).orElse(null));	
		
		return userRepository.save(newEntity);
	}
	@Override
	public User update(UserDTO user) throws Exception{
		User existing = userRepository.findById(user.getId()).orElse(null);
		if(existing == null){
			throw new Exception("User doesn't exist");
		}
		//update entity
		existing.setFirstName(user.getFirstName());
		existing.setLastName(user.getLastName());
		existing.setLibrary(libraryReposiroty.findById(user.getLibrary().getId()).orElse(null));	
		
		return userRepository.save(existing);
	}
	@Override
	public User remove(Long id)  throws Exception{
		User existing = userRepository.findById(id).orElse(null);
		if(existing == null){
			throw new Exception("User doesn't exist");
		}
		userRepository.delete(existing);
		
		return existing;
	}
}