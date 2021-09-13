package com.training.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.training.config.AppConfig;
import com.training.model.service.BookService;

public class GetAllBooks {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		BookService service=(BookService) ctx.getBean("bookService");
		
		service.getAllBooks().forEach(System.out::println);
	}

}
