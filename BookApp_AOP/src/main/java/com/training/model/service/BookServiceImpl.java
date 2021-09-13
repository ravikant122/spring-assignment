package com.training.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.model.dao.Book;
import com.training.model.dao.BookDao;

@Service(value="bookService")
public class BookServiceImpl implements BookService {
	
	private BookDao dao;

	@Autowired
	public BookServiceImpl(BookDao dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Book> getAllBooks() {
		return dao.getAllBooks();
	}

	@Override
	public void addBook(Book book) {
		dao.addBook(book);
	}

	@MyLogging
	@Override
	public void deleteBook(int id) {
		dao.deleteBook(id);
	}
	
	@Override
	public void updateBook(int id, Book book) {
		dao.updateBook(id, book);
	}

	@Override
	public Book getBookById(int id) {
		return dao.getBookById(id);
	}

}	
