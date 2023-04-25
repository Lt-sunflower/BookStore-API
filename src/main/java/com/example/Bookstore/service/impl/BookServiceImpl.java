package com.example.Bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.repository.BookRepository;
import com.example.Bookstore.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public Book add(Book book) {
		
		// Check if book exist, return null
		if (!bookRepository.findById(book.getIsbn()).isEmpty())
			return null;
		
		return bookRepository.save(book);
	}

	@Override
	public Book update(Book book) {
		
		// if not exist??
		
		Book existingBook = bookRepository.findById(book.getIsbn()).get();
		existingBook.setTitle(book.getTitle());
		existingBook.setAuthors(book.getAuthors());
		existingBook.setYear(book.getYear());
		existingBook.setPrice(book.getPrice());
		existingBook.setGenre(book.getGenre());
		Book updatedBook = bookRepository.save(existingBook);

		return updatedBook;
	}

	@Override
	public List<Book> search(com.example.Bookstore.model.SearchParam params) {
		
		return bookRepository.findDistinctByAuthors_Name_OrTitle(params.getAuthorNameField(), params.getTitleField());
	}

	@Override
	@PreAuthorize("hasAuthority('ADMIN')")
	public void delete(String isbn) {
		
		bookRepository.deleteById(isbn);		
	}

}
