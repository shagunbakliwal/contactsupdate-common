package com.contactsupdate.web;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Shagun Bakliwal
 * @param <T>
 *
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResponseEntity<T> {
	private T body;
	private HttpStatus status;

	/**
	 * @param body
	 * @param status
	 */
	public ResponseEntity(T body, HttpStatus status) {
		this.body = body;
		this.status = status;
	}

	public ResponseEntity(T body) {
		super();
		this.body = body;
	}

	public T getBody() {
		return this.body;
	}

	public void setBody(T body) {
		this.body = body;
	}

	public HttpStatus getStatus() {
		return this.status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
