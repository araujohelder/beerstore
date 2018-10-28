package com.hibicode.beerstore.error;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {
	
	private final int statusCode;
	private final List<ApiError> errors;
	
	static ErrorResponse of (HttpStatus status, List<ApiError> errors ) {
		return new ErrorResponse(status.value(), errors);
	}
	
	static ErrorResponse of (HttpStatus status, ApiError errors ) {
		return new ErrorResponse(status.value(), Collections.singletonList(errors));
	}
	
	@JsonAutoDetect(fieldVisibility = Visibility.ANY)
	@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
	static class ApiError {
		private final String code;
		private final String message;
		
		public String getCode() {
			return code;
		}
		public String getMessage() {
			return message;
		}		
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	public List<ApiError> getErrors() {
		return errors;
	}
}