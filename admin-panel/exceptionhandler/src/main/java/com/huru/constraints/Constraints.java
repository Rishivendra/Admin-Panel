package com.huru.constraints;

public class Constraints {

	public static final String EMPTY_OR_NULL_NAME = "Name Field Can Not Be Empty Or Null";

	public static final String EMPTY_OR_NULL_DESCRIPTION = "Description of Product Can Not Be Empty Or Null";
	public static final String EMPTY_OR_NULL_IMAGE = "Image Of Product Not Empty Or Null";
	public static final String QUANTITY_NOT_ZERO = "Quantity Of Product Can Not Be Zero";
	public static final String EMPTY_OR_NULL_TERMS_AND_CONDITIONS = "Terms And Conditions of Product Can Not Be Empty Or Null";

	public static final String PRODUCT_NOT_FOUND = "Product Not Found";
	public static final String INVALID_PRODUCT_REQUEST = "Invalid Product Request";

	public static final String EMPTY_OR_NULL_EMAIL = "Email Field Is Empty Or Null";
	public static final String EMAIL_NOT_VALID = "Invalid Email Address";

	public static final String EMPTY_OR_NULL_PASSWORD = "Password Field Can Not Be Empty Or Null";
	public static final String PASSWORD_LENGTH_NOT_VALID = "Password Must Be At Least 8 Characters Long";
	public static final String PASSWORD_UPPERCASE_MISSING = "Password Must Contain At Least One Uppercase Letter";
	public static final String PASSWORD_NUMERIC_MISSING = "Password Must Contain At Least One Numeric Digit";
	public static final String PASSWORD_SPECIAL_CHARACTER_MISSING = "Password Must Contain At Least One Special Character";

	public static final String EMPTY_OR_NULL_MOBILE_NUMBER = "Mobile Number Field Can Not Be Empty Or Null";

	public static final String USER_AlREADY_EXIST = "User With Email Already Exist";
	public static final String USER_NOT_FOUND = "User With This Email Not Found";
	public static final String USER_PASSWORD_INCORRECT = "Password Incorrect";

	public static final String ALL_PRODUCTS = "/products";
	public static final String PRODUCT_BY_ID = "/product/{id}";

	public static final String SIGNUP = "/signup";
	public static final String SIGNIN = "/signin";
	public static final String SIGNOUT = "/signout";

	public static final String PRODUCT_RETRIEVED = "Product Retrieved Successfully";
	public static final String PRODUCT_CREATED = "Product Created Successfully";
	public static final String PRODUCT_UPDATED = "Product Updated Successfully";
	public static final String PRODUCT_DELETED = "Product Deleted Successfully";

	public static final String USER_SIGNUP = "User Signup Successfully";
	public static final String USER_SIGNIN = "User Signin Successfully";
	public static final String USER_SIGNOUT = "User Signout Successfully";

	public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";

	public static final String INVALID_ENDPOINT = "Provide Correct Endpont";

}
