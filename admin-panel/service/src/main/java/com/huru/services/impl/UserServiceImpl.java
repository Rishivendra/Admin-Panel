package com.huru.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huru.dto.UserDto;

import com.huru.entity.UserEntity;

import com.huru.repos.IUserRepository;

import com.huru.response.GetUserResponse;
import com.huru.services.IUserService;
import com.huru.utility.Converter;
import com.huru.utility.UserValidator;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public GetUserResponse saveUser(UserDto userDto) {
		UserValidator.validateSignupUser(userDto, userRepository);
		UserEntity user = Converter.toUserEntity(userDto);
		UserEntity saveUser = userRepository.save(user);
		UserDto UserDto = Converter.toUserDto(saveUser);
		GetUserResponse userResponse = new GetUserResponse();
		userResponse.setUserDto(UserDto);
		return userResponse;
	}

}
