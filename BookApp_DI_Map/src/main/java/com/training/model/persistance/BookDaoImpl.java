package com.training.model.persistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.training.model.entity.Book;

public class BookDaoImpl implements BookDao {

	private static Map<Integer, Book> booksMap = new HashMap<Integer, Book>();
	private static int counter;
	
	
	public static Map<Integer, Book> getBooksMap() {
		return booksMap;
	}
	public static void setBooksMap(Map<Integer, Book> booksMap) {
		BookDaoImpl.booksMap = booksMap;
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		BookDaoImpl.counter = counter;
	}
	public List<Book> getAllBooks() {
		return new ArrayList<Book>(booksMap.values());
	}
	public Book addBook(Book book) {
		book.setId(++counter);
		booksMap.put(counter,book);
		return booksMap.get(counter);
	}
	public void deleteBook(int id) {
		booksMap.remove(id);
	}
	public void updateBook(int id, Book book) {
		booksMap.put(id,book);
	}
	public Book getBookById(int id) {
		return booksMap.get(id);
	}

}
