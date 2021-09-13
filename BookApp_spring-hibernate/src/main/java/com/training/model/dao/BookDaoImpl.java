package com.training.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.model.exceptions.BookNotFoundException;

@Repository
public class BookDaoImpl implements BookDao {
	
private SessionFactory sessionFactory;
	
	@Autowired
	public BookDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Book getBookById(int id) {
		Book book=getSession().find(Book.class, id);
		if(book==null)
			throw new BookNotFoundException("account with id : "+ id + " is not found");
		return book;
	}
	
	@Override
	public List<Book> getAllBooks() {
		return getSession().createQuery("select b from Book b", Book.class).getResultList();
	}

	// there is only one method = update = which does insert/update/delete
	
	@Override
	public void updateBook(int id,Book book) {
		Book bookToUpdate=getBookById(id);
		bookToUpdate.setPrice(book.getPrice());
		getSession().merge(bookToUpdate);
	}

	@Override
	public void addBook(Book book) {
		getSession().persist(book);
	}

	@Override
	public void deleteBook(int id) {
		Book bookToDelete=getBookById(id);
		getSession().delete(bookToDelete);
	}

}
