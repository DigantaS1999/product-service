package com.diganta.exception;

public class ProductAlreadyExists extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductAlreadyExists(String msg) {
		super(msg);
	}
}