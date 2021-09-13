package com.training.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.model.service.BookService;

public class GetAllBooks {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		BookService service=(BookService) ctx.getBean("bookService");
		
		service.getAllBooks().forEach(System.out::println);
	}

}
