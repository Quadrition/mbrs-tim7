package uns.ftn.mbrs.controller;

import java.util.List;
import java.util.Date;
import uns.ftn.mbrs.model.*;


import uns.ftn.mbrs.model.Library;
import uns.ftn.mbrs.service.LibraryService;
import uns.ftn.mbrs.converter.LibraryDTOToLibrary;
import uns.ftn.mbrs.converter.LibraryToLibraryDTO;
import uns.ftn.mbrs.dto.LibraryDTO;

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
@RequestMapping(value="/api/library")
public class LibraryController {  

	@Autowired
	private LibraryService libraryService;
	
	@Autowired
	private LibraryToLibraryDTO toDTO;
	
	@Autowired
	private LibraryDTOToLibrary toLibrary;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<LibraryDTO>> getLibraryList () {

		List<Library> libraryList = libraryService.findAll();
	
		return new ResponseEntity<>(toDTO.convert(libraryList), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<LibraryDTO> getLibrary(@PathVariable Long id) {
		Library library = libraryService.findOne(id);
		if (library == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(library), HttpStatus.OK);
	}
	

	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<LibraryDTO> add(@RequestBody @Valid LibraryDTO newLibrary) {

		Library savedLibrary = libraryService.save(toLibrary.convert(newLibrary));

		return new ResponseEntity<>(toDTO.convert(savedLibrary), HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<LibraryDTO> edit(@RequestBody @Valid LibraryDTO library, @PathVariable Long id) {

		if (id != library.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Library persisted = libraryService.save(toLibrary.convert(library));

		return new ResponseEntity<>(toDTO.convert(persisted), HttpStatus.OK);
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<LibraryDTO> delete(@PathVariable Long id) {
		Library deleted = libraryService.remove(id);

		return new ResponseEntity<>(toDTO.convert(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/filterByName/{value}", method = RequestMethod.GET)
	ResponseEntity<List<LibraryDTO>> getLibraryListByName(@PathVariable String  value) {

		List<Library> libraryList = libraryService.findByName(value);
			
		return new ResponseEntity<>(toDTO.convert(libraryList), HttpStatus.OK);
	}

}