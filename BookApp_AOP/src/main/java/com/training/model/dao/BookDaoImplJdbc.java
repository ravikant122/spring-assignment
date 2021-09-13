package com.training.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImplJdbc implements BookDao {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Book getBookById(int id) {
		String FIND_BY_ID = "select * from book_table where id=?";
		return jdbcTemplate.queryForObject(FIND_BY_ID,new BookRowMapper(), id);
	}
	
	@Override
	public List<Book> getAllBooks() {
		String FIND_ALL = "select * from book_table";
		return jdbcTemplate.query(FIND_ALL, new BookRowMapper());
	}

	// there is only one method = update = which does insert/update/delete
	
	@Override
	public void updateBook(int id,Book book) {
		String UPDATE_QUERY = "update book_table set price =? where id=?";
		jdbcTemplate.update(UPDATE_QUERY, new Object[] {book.getPrice(), book.getId()});
		// object[] array = array of ?
	}

	@Override
	public void addBook(Book book) {
		String INSERT_QUERY = "insert into book_table(id, title, isbn,author,price) values(?,?,?,?,?)";
		jdbcTemplate.update(INSERT_QUERY, 
				new Object[] { book.getId(), book.getTitle(), book.getIsbn(),book.getAuthor(),book.getPrice() });
	}

	@Override
	public void deleteBook(int id) {
		String DELETE_QUERY = "delete from book_table where id=?";
		jdbcTemplate.update(DELETE_QUERY, new Object[] {id});
	}

}
