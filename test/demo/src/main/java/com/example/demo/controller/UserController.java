package com.example.demo.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;



import com.example.demo.model.*;
import com.example.demo.service.*;
import com.example.demo.mapper.*;
import com.example.demo.dto.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/user")
public class UserController {  

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<ArrayList<UserDTO>> getUserList () {

		List<User> userList = userService.findAll();
	
		return new ResponseEntity<>(UserMapper.toDtoList(userList), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
		User user = userService.findOne(id);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(UserMapper.toDto(user), HttpStatus.OK);
	}
	

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<UserDTO> add(@RequestBody @Valid UserDTO newUser) {

		User savedUser = userService.save(newUser);

		return new ResponseEntity<>(UserMapper.toDto(savedUser), HttpStatus.CREATED);
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<UserDTO> edit(@RequestBody @Valid UserDTO user, @PathVariable Long id) {

		if (id != user.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		User persisted;
		try {
			persisted = userService.update(user);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(UserMapper.toDto(persisted), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<UserDTO> delete(@PathVariable Long id) {
		User deleted;
		try {
			deleted = userService.remove(id);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		

		return new ResponseEntity<>(UserMapper.toDto(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/filterByFirstName/{value}", method = RequestMethod.GET)
	ResponseEntity<ArrayList<UserDTO>> getUserListByFirstName(@PathVariable String  value) {

		List<User> userList = userService.findByFirstName(value);
			
		return new ResponseEntity<>(UserMapper.toDtoList(userList), HttpStatus.OK);
	}

	@RequestMapping(value = "/filterByLastName/{value}", method = RequestMethod.GET)
	ResponseEntity<ArrayList<UserDTO>> getUserListByLastName(@PathVariable String  value) {

		List<User> userList = userService.findByLastName(value);
			
		return new ResponseEntity<>(UserMapper.toDtoList(userList), HttpStatus.OK);
	}

}