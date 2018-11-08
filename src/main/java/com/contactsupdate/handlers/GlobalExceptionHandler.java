package com.contactsupdate.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.contactsupdate.exception.NotFoundException;
import com.contactsupdate.web.ResponseEntity;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ResponseEntity handleNotFoundException(NotFoundException iue, HttpServletRequest request,
			HttpServletResponse resp) {
		return new ResponseEntity<>(iue.getMessage());
	}

	@ExceptionHandler(value = org.springframework.data.mongodb.UncategorizedMongoDbException.class)
	@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
	public @ResponseBody ResponseEntity connectionException(
			org.springframework.data.mongodb.UncategorizedMongoDbException ce, HttpServletRequest request,
			HttpServletResponse resp) {
		return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
	}

	@ExceptionHandler(value = com.mongodb.MongoTimeoutException.class)
	@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
	public @ResponseBody ResponseEntity timeoutException(com.mongodb.MongoTimeoutException mte,
			HttpServletRequest request, HttpServletResponse resp) {
		return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
	}

}
