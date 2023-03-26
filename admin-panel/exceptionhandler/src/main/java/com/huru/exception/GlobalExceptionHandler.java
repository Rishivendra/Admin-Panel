package com.huru.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode().getErrorcode(), ex.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidFieldException.class)
	public ResponseEntity<ErrorResponse> handleInvalidFieldException(InvalidFieldException ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode().getErrorcode(), ex.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleProductAlreadyExistsException(AlreadyExistsException ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode().getErrorcode(), ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex) {
		ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR.getErrorcode(),
				ErrorCode.INTERNAL_SERVER_ERROR + " : " + ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InvalidEndpointException.class)
	public ResponseEntity<ErrorResponse> handleInvalidEndpointException(InvalidEndpointException ex) {
		ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INVALID_ENDPOINT.getErrorcode(), ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
