package uns.ftn.mbrs.service;

import java.util.List;
import java.util.Date;

public interface UserService {

	User findOne(Long id);
	
	List<User> findAll();
	
	List<User> findByFirstName(String firstName);
	List<User> findByLastName(String lastName);

}