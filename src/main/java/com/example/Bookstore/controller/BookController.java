package com.example.Bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.SearchParam;
import com.example.Bookstore.service.AuthorService;
import com.example.Bookstore.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	BookService bookService;
	
	@Autowired
	AuthorService authorService;
	
	@GetMapping
	public ResponseEntity<String> test() {
		
		return ResponseEntity.ok("Hello World");
	}
	
	@PostMapping("/add")
	public ResponseEntity<Book> add(@RequestBody final Book book) {
		
		Book res = bookService.add(book);
		
		if (res == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(res, HttpStatus.CREATED);
		
	}
	
	@PatchMapping("/update")
	public ResponseEntity<Book> update(@RequestBody final Book book) {
		
		Book res = bookService.update(book);
		
		return new ResponseEntity<>(res, HttpStatus.OK);
		
	}
	
	@PostMapping("/search")
	public ResponseEntity<List<Book>> search(@RequestBody SearchParam params) {
		
		List<Book> books = bookService.search(params);
		
	
		return new ResponseEntity<>(books, HttpStatus.FOUND);
		
	}
	
	@DeleteMapping("/delete/{isbn}")
	public ResponseEntity<String> delete(@PathVariable String isbn) {
		
		bookService.delete(isbn);
		
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
		
	}
	
}
