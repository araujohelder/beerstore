package com.hibicode.beerstore.service.exception;

import org.springframework.http.HttpStatus;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BusinessExcpetion extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String code;
	private final HttpStatus status;
	
	public String getCode() {
		return code;
	}
	public HttpStatus getStatus() {
		return status;
	}
}
