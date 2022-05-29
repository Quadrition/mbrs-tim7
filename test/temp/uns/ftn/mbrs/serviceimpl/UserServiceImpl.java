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
	private Myplugin.generator.fmmodel.FMType@65ac8c1cRepository myplugin.generator.fmmodel.FMType@65ac8c1cReposiroty;
	
	@Override
	public User findOne(Long id){
		return userRepository.findById(id);
	}
	
	@Override
	List<User> findAll(){
		return userRepository.findAll();
	}
	
	@Override
	List<User> findByFirstName(myplugin.generator.fmmodel.FMType@6b7801ae firstName){
		return userRepository.findByFirstName(firstName);
	}
	@Override
	List<User> findByLastName(myplugin.generator.fmmodel.FMType@2088940c lastName){
		return userRepository.findByLastName(lastName);
	}

	@Override
	User save(UserDTO user){
		User newEntity = new User();
		newEntity.setFirstName(user.getFirstName());
		newEntity.setLastName(user.getLastName());
		newEntity.setLibrary(myplugin.generator.fmmodel.FMType@65ac8c1cReposiroty.findOne(user.getLibrary().getId()));	
		
		return userRepository.save(newEntity);
	}
	@Override
	User update(UserDTO user){
		User existing = userRepository.findById(id);
		if(existing == null){
			throw new Exception("User doesn't exist");
		}
		//update entity
		existing.setFirstName(user.getFirstName());
		existing.setLastName(user.getLastName());
		existing.setLibrary(myplugin.generator.fmmodel.FMType@65ac8c1cReposiroty.findOne(user.getLibrary().getId()));	
		
		return userRepository.save(existing);
	}
	@Override
	User remove(Long id){
		User existing = userRepository.findById(id);
		if(existing == null){
			throw new Exception("User doesn't exist");
		}
		userRepository.delete(existing);
		
		return existing;
	}
}