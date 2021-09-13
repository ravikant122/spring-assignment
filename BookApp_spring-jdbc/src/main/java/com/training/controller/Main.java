package com.training.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.model.dao.Book;
import com.training.model.service.BookService;

public class Main {
	public static void main(String[] args) {
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		
		BookService bookService = ctx.getBean("bookService",BookService.class);
		
		Book book = new Book("dsfkj3223","dfsnfds","oioiy",6745.4);
		bookService.addBook(book);
		
		System.out.println(bookService.getBookById(1));
		bookService.getAllBooks().forEach(System.out::println);
		
		bookService.deleteBook(1);
	}
}
