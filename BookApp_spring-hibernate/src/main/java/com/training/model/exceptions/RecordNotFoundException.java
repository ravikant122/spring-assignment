package com.training.model.exceptions;

public class RecordNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -1421570197818210759L;

	public RecordNotFoundException(String message) {
		super(message);
	}

}