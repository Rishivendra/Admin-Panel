package com.huru.exception;

import com.huru.constraints.Constraints;

public enum ErrorCode {

	EMPTY_OR_NULL_NAME(400, Constraints.EMPTY_OR_NULL_NAME),
	EMPTY_OR_NULL_DESCRIPTION(400, Constraints.EMPTY_OR_NULL_DESCRIPTION),
	EMPTY_OR_NULL_IMAGE(400, Constraints.EMPTY_OR_NULL_IMAGE), QUANTITY_NOT_ZERO(404, Constraints.QUANTITY_NOT_ZERO),
	EMPTY_OR_NULL_TERMS_AND_CONDITIONS(400, Constraints.EMPTY_OR_NULL_TERMS_AND_CONDITIONS),

	PRODUCT_NOT_FOUND(403, Constraints.PRODUCT_NOT_FOUND),
	INVALID_PRODUCT_REQUEST(403, Constraints.INVALID_PRODUCT_REQUEST),

	EMPTY_OR_NULL_EMAIL(400, Constraints.EMPTY_OR_NULL_EMAIL), EMAIL_NOT_VALID(400, Constraints.EMAIL_NOT_VALID),

	EMPTY_OR_NULL_PASSWORD(400, Constraints.EMPTY_OR_NULL_PASSWORD),
	PASSWORD_LENGTH_NOT_VALID(400, Constraints.PASSWORD_LENGTH_NOT_VALID),
	PASSWORD_UPPERCASE_MISSING(400, Constraints.PASSWORD_UPPERCASE_MISSING),
	PASSWORD_NUMERIC_MISSING(400, Constraints.PASSWORD_NUMERIC_MISSING),
	PASSWORD_SPECIAL_CHARACTER_MISSING(400, Constraints.PASSWORD_SPECIAL_CHARACTER_MISSING),

	EMPTY_OR_NULL_MOBILE_NUMBER(400, Constraints.EMPTY_OR_NULL_MOBILE_NUMBER),

	USER_AlREADY_EXIST(403, Constraints.USER_AlREADY_EXIST), USER_NOT_FOUND(403, Constraints.USER_NOT_FOUND),
	USER_PASSWORD_INCORRECT(400, Constraints.USER_PASSWORD_INCORRECT),
	INTERNAL_SERVER_ERROR(500, Constraints.INTERNAL_SERVER_ERROR), INVALID_ENDPOINT(404, Constraints.INVALID_ENDPOINT);

	private final int errorCode;
	private final String erroMessage;

	ErrorCode(int errorCode, String erroMessage) {
		this.errorCode = errorCode;
		this.erroMessage = erroMessage;
	}

	public int getErrorcode() {
		return errorCode;
	}

	public String getErromessage() {
		return erroMessage;
	}

}
