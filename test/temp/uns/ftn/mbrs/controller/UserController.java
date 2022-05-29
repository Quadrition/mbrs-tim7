package uns.ftn.mbrs.controller;

import java.util.List;
import java.util.Date;
import uns.ftn.mbrs.model.*;


import uns.ftn.mbrs.model.User;
import uns.ftn.mbrs.service.UserService;
import uns.ftn.mbrs.converter.UserDTOToUser;
import uns.ftn.mbrs.converter.UserToUserDTO;
import uns.ftn.mbrs.dto.UserDTO;

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
	
	@Autowired
	private UserToUserDTO toDTO;
	
	@Autowired
	private UserDTOToUser toUser;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<UserDTO>> getUserList () {

		List<User> userList = userService.findAll();
	
		return new ResponseEntity<>(toDTO.convert(userList), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
		User user = userService.findOne(id);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(user), HttpStatus.OK);
	}
	

	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<UserDTO> add(@RequestBody @Valid UserDTO newUser) {

		User savedUser = userService.save(toUser.convert(newUser));

		return new ResponseEntity<>(toDTO.convert(savedUser), HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<UserDTO> edit(@RequestBody @Valid UserDTO user, @PathVariable Long id) {

		if (id != user.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		User persisted = userService.save(toUser.convert(user));

		return new ResponseEntity<>(toDTO.convert(persisted), HttpStatus.OK);
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<UserDTO> delete(@PathVariable Long id) {
		User deleted = userService.remove(id);

		return new ResponseEntity<>(toDTO.convert(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/filterByFirstName/{value}", method = RequestMethod.GET)
	ResponseEntity<List<UserDTO>> getUserListByFirstName(@PathVariable String  value) {

		List<User> userList = userService.findByFirstName(value);
			
		return new ResponseEntity<>(toDTO.convert(userList), HttpStatus.OK);
	}

	@RequestMapping(value = "/filterByLastName/{value}", method = RequestMethod.GET)
	ResponseEntity<List<UserDTO>> getUserListByLastName(@PathVariable String  value) {

		List<User> userList = userService.findByLastName(value);
			
		return new ResponseEntity<>(toDTO.convert(userList), HttpStatus.OK);
	}

	@RequestMapping(value = "/filterByLibraryId/{id}", method = RequestMethod.GET)
	ResponseEntity<List<UserDTO>> getUserListByLibraryId(@PathVariable Long id) {

		List<User> userList = userService.findByLibrary(id);
			
		return new ResponseEntity<>(toDTO.convert(userList), HttpStatus.OK);
	}

}