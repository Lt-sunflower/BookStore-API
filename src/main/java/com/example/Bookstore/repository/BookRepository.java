package com.example.Bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Bookstore.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
	
//	List<Book> findByAuthors_Name(String name);
//
//	List<Book> findByTitle(String title);
	
	List<Book> findDistinctByAuthors_Name_OrTitle(String authorNameField, String titleField);

}
