package com.huru.exception;

public class AlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final ErrorCode errorCode;

	public AlreadyExistsException(ErrorCode errorCode) {
		super(errorCode.getErromessage());
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

}
