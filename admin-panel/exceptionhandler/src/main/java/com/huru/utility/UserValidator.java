package com.huru.utility;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.huru.dto.LoginDto;
import com.huru.dto.UserDto;
import com.huru.exception.AlreadyExistsException;
import com.huru.exception.ErrorCode;
import com.huru.exception.InvalidFieldException;
import com.huru.exception.NotFoundException;
import com.huru.repos.IUserRepository;

public class UserValidator {

	public static void validateSignupUser(UserDto userDto, IUserRepository userRepository) {
		if (userRepository.existsByEmail(userDto.getEmail())) {
			throw new AlreadyExistsException(ErrorCode.USER_AlREADY_EXIST);
		}

		if (StringUtils.isEmpty(userDto.getName())) {
			throw new InvalidFieldException(ErrorCode.EMPTY_OR_NULL_NAME);
		}

		if (StringUtils.isEmpty(userDto.getEmail())) {
			throw new InvalidFieldException(ErrorCode.EMPTY_OR_NULL_EMAIL);
		}

		if (!userDto.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
			throw new InvalidFieldException(ErrorCode.EMAIL_NOT_VALID);
		}

		if (Objects.isNull(userDto.getPassword()) || userDto.getPassword().isEmpty()) {
			throw new InvalidFieldException(ErrorCode.EMPTY_OR_NULL_PASSWORD);
		}

		if (userDto.getPassword().length() < 8) {
			throw new InvalidFieldException(ErrorCode.PASSWORD_LENGTH_NOT_VALID);
		}

		if (!userDto.getPassword().matches(".*[A-Z].*")) {
			throw new InvalidFieldException(ErrorCode.PASSWORD_UPPERCASE_MISSING);
		}

		if (!userDto.getPassword().matches(".*[0-9].*")) {
			throw new InvalidFieldException(ErrorCode.PASSWORD_NUMERIC_MISSING);
		}

		if (!userDto.getPassword().matches(".*[!@#$%^&*()].*")) {
			throw new InvalidFieldException(ErrorCode.PASSWORD_SPECIAL_CHARACTER_MISSING);
		}

		if (StringUtils.isEmpty(userDto.getMobno())) {
			throw new InvalidFieldException(ErrorCode.EMPTY_OR_NULL_MOBILE_NUMBER);
		}
	}

	public static void validateSigninUser(LoginDto loginDto, IUserRepository userRepository) {
		if (Objects.isNull(userRepository.findByEmail(loginDto.getEmail()))) {
			throw new NotFoundException(ErrorCode.USER_NOT_FOUND);
		}
		if (!userRepository.findByEmail(loginDto.getEmail()).getPassword().equals(loginDto.getPassword())) {
			throw new InvalidFieldException(ErrorCode.USER_PASSWORD_INCORRECT);
		}
	}

}
