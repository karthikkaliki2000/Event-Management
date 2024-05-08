package com.cn.cnEvent.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ElementAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ElementAlreadyExistException(String message) {
		super(message);
		System.out.println(message);
	}
	

}
