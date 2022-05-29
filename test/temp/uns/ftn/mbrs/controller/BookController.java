package uns.ftn.mbrs.controller;

import java.util.List;
import java.util.Date;
import uns.ftn.mbrs.model.*;


import uns.ftn.mbrs.model.Book;
import uns.ftn.mbrs.service.BookService;
import uns.ftn.mbrs.converter.BookDTOToBook;
import uns.ftn.mbrs.converter.BookToBookDTO;
import uns.ftn.mbrs.dto.BookDTO;

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
@RequestMapping(value="/api/book")
public class BookController {  

	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookToBookDTO toDTO;
	
	@Autowired
	private BookDTOToBook toBook;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<BookDTO>> getBookList () {

		List<Book> bookList = bookService.findAll();
	
		return new ResponseEntity<>(toDTO.convert(bookList), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<BookDTO> getBook(@PathVariable Long id) {
		Book book = bookService.findOne(id);
		if (book == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(book), HttpStatus.OK);
	}
	

	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<BookDTO> add(@RequestBody @Valid BookDTO newBook) {

		Book savedBook = bookService.save(toBook.convert(newBook));

		return new ResponseEntity<>(toDTO.convert(savedBook), HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<BookDTO> edit(@RequestBody @Valid BookDTO book, @PathVariable Long id) {

		if (id != book.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Book persisted = bookService.save(toBook.convert(book));

		return new ResponseEntity<>(toDTO.convert(persisted), HttpStatus.OK);
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<BookDTO> delete(@PathVariable Long id) {
		Book deleted = bookService.remove(id);

		return new ResponseEntity<>(toDTO.convert(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/filterByLibraryId/{id}", method = RequestMethod.GET)
	ResponseEntity<List<BookDTO>> getBookListByLibraryId(@PathVariable Long id) {

		List<Book> bookList = bookService.findByLibrary(id);
			
		return new ResponseEntity<>(toDTO.convert(bookList), HttpStatus.OK);
	}

	@RequestMapping(value = "/filterByCategoryId/{id}", method = RequestMethod.GET)
	ResponseEntity<List<BookDTO>> getBookListByCategoryId(@PathVariable Long id) {

		List<Book> bookList = bookService.findByCategory(id);
			
		return new ResponseEntity<>(toDTO.convert(bookList), HttpStatus.OK);
	}

	@RequestMapping(value = "/filterByTitle/{value}", method = RequestMethod.GET)
	ResponseEntity<List<BookDTO>> getBookListByTitle(@PathVariable String  value) {

		List<Book> bookList = bookService.findByTitle(value);
			
		return new ResponseEntity<>(toDTO.convert(bookList), HttpStatus.OK);
	}

	@RequestMapping(value = "/filterByYear/{value}", method = RequestMethod.GET)
	ResponseEntity<List<BookDTO>> getBookListByYear(@PathVariable int  value) {

		List<Book> bookList = bookService.findByYear(value);
			
		return new ResponseEntity<>(toDTO.convert(bookList), HttpStatus.OK);
	}

	@RequestMapping(value = "/filterByAgeRecommendation/{value}", method = RequestMethod.GET)
	ResponseEntity<List<BookDTO>> getBookListByAgeRecommendation(@PathVariable Age  value) {

		List<Book> bookList = bookService.findByAgeRecommendation(value);
			
		return new ResponseEntity<>(toDTO.convert(bookList), HttpStatus.OK);
	}

}