package uns.ftn.mbrs.service;

import java.util.List;
import java.util.Date;

public interface UserService {

	User findOne(Long id);
	
	List<User> findAll();
	
	List<User> findByFirstName(myplugin.generator.fmmodel.FMType@2b2ce208 firstName);
	List<User> findByLastName(myplugin.generator.fmmodel.FMType@26e38067 lastName);

	User save(UserDTO user);
	User update(UserDTO user);
	User remove(Long id);
}