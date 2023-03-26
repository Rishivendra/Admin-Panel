package com.huru.exception;

public class InvalidFieldException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final ErrorCode errorCode;

	public InvalidFieldException(ErrorCode errorCode) {
		super(errorCode.getErromessage());
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

}
