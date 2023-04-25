package com.example.Bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bookstore.model.Author;
import com.example.Bookstore.repository.AuthorRepository;
import com.example.Bookstore.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository authorRepository;

	@Override
	public Author add(Author author) {
		
		return authorRepository.save(author);
	}
	
	
}
