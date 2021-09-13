package com.training.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book book=new Book();
		book.setId(rs.getInt("id"));
		book.setIsbn(rs.getString("isbn"));
		book.setTitle(rs.getString("title"));
		book.setAuthor(rs.getString("author"));
		book.setPrice(rs.getDouble("price"));
		
		return book;
	}

}
