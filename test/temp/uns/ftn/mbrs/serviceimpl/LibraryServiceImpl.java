package uns.ftn.mbrs.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@Service
public class LibraryServiceImpl implements LibraryService{

	@Autowired
	private LibraryRepository libraryRepository;
	
	@Autowired
	private Myplugin.generator.fmmodel.FMType@4249a305Repository myplugin.generator.fmmodel.FMType@4249a305Reposiroty;
	
	@Autowired
	private Myplugin.generator.fmmodel.FMType@4237eaeaRepository myplugin.generator.fmmodel.FMType@4237eaeaReposiroty;
	
	@Override
	public Library findOne(Long id){
		return libraryRepository.findById(id);
	}
	
	@Override
	List<Library> findAll(){
		return libraryRepository.findAll();
	}
	
	@Override
	List<Library> findByName(myplugin.generator.fmmodel.FMType@7bb43351 name){
		return libraryRepository.findByName(name);
	}

	@Override
	Library save(LibraryDTO library){
		Library newEntity = new Library();
		newEntity.setName(library.getName());
		// asocijacija myplugin.generator.fmmodel.FMType@4249a305Reposiroty		
		// asocijacija myplugin.generator.fmmodel.FMType@4237eaeaReposiroty		
		
		return libraryRepository.save(newEntity);
	}
	@Override
	Library update(LibraryDTO library){
		Library existing = libraryRepository.findById(id);
		if(existing == null){
			throw new Exception("Library doesn't exist");
		}
		//update entity
		existing.setName(library.getName());
		// asocijacija myplugin.generator.fmmodel.FMType@4249a305Reposiroty				
		// asocijacija myplugin.generator.fmmodel.FMType@4237eaeaReposiroty				
		
		return libraryRepository.save(existing);
	}
	@Override
	Library remove(Long id){
		Library existing = libraryRepository.findById(id);
		if(existing == null){
			throw new Exception("Library doesn't exist");
		}
		libraryRepository.delete(existing);
		
		return existing;
	}
}