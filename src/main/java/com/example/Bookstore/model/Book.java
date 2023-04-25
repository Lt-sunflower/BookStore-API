package com.example.Bookstore.model;

import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Books")
public class Book {

	@Id
	private String isbn;
	
	private String title;
	
//	@OneToMany(targetEntity = com.example.Bookstore.model.Author.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@ManyToMany(cascade = {CascadeType.MERGE})
	@JoinTable(
			name = "books_authors",
			joinColumns = @JoinColumn(name="isbn"),
			inverseJoinColumns = @JoinColumn(name="id"))
	private Set<Author> authors;
	
	private int year;
	
	private double price;
	
	private String genre;
	
}
