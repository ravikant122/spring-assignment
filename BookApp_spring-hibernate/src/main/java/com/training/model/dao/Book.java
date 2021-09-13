package com.training.model.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Book {
	private int id;
	private String isbn;
	private String title;
	private String author;
	private double price;
	
	public Book(String isbn, String title, String author, double price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	
}
