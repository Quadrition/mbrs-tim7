package uns.ftn.mbrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;
import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	List<User> findByFirstName(String  firstName);
	
		
	
	List<User> findByLastName(String  lastName);
	
		
		List<User> findByLibrary(Long id);
	
		
}