package com.diganta.exception;

public class CategoryAlreadyExists extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CategoryAlreadyExists(String msg) {
		super(msg);
	}
}