package com.training.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.model.entity.Book;
import com.training.model.persistance.BookDao;

@Service(value="bookService")
public class BookServiceImpl implements BookService {
	
	private BookDao dao;

	@Autowired
	public BookServiceImpl(BookDao dao) {
		this.dao = dao;
	}

	public List<Book> getAllBooks() {
		return dao.getAllBooks();
	}

	public Book addBook(Book book) {
		return dao.addBook(book);
	}

	public void deleteBook(int id) {
		dao.deleteBook(id);
	}

	public void updateBook(int id, Book book) {
		dao.updateBook(id, book);
	}

	public Book getBookById(int id) {
		return dao.getBookById(id);
	}

}	
