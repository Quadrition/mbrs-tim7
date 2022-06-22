package uns.ftn.mbrs.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LibraryRepository libraryReposiroty;
	
	@Override
	public User findOne(Long id){
		return userRepository.findById(id);
	}
	
	@Override
	List<User> findAll(){
		return userRepository.findAll();
	}
	
	@Override
	List<User> findByFirstName(String firstName){
		return userRepository.findByFirstName(firstName);
	}
	@Override
	List<User> findByLastName(String lastName){
		return userRepository.findByLastName(lastName);
	}

}