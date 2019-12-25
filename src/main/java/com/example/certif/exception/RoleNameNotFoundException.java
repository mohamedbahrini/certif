package com.example.certif.exception;

public class RoleNameNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoleNameNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
