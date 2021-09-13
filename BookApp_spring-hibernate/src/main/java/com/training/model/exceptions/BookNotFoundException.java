package com.training.model.exceptions;

public class BookNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -1421570197818210759L;

	public BookNotFoundException(String message) {
		super(message);
	}

}
