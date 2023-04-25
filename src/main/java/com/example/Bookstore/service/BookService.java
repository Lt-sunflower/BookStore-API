package com.example.Bookstore.service;

import java.util.List;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.SearchParam;

public interface BookService {

	Book add(Book book);

	Book update(Book book);

	List<Book> search(SearchParam params);

	void delete(String isbn);
	
}
