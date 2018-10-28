package com.hibicode.beerstore.service.exception;

import org.springframework.http.HttpStatus;

public class BeerAlreadyExistExcpetion extends BusinessExcpetion {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BeerAlreadyExistExcpetion() {
		super("beers-5", HttpStatus.BAD_REQUEST);
	}
}
