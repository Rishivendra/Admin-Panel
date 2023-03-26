package com.huru.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huru.dto.LoginDto;

import com.huru.entity.UserEntity;

import com.huru.repos.IUserRepository;
import com.huru.response.GetLoginResponse;

import com.huru.services.ILoginService;
import com.huru.utility.UserValidator;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private IUserRepository userRepository;

	public LoginServiceImpl(IUserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public GetLoginResponse authenticateUser(LoginDto loginDto) {
		UserValidator.validateSigninUser(loginDto, userRepository);
		UserEntity user = userRepository.findByEmail(loginDto.getEmail());
		LoginDto loginDtos = toLoginDto(user);
		GetLoginResponse loginResponse = new GetLoginResponse();
		loginResponse.setLoginDto(loginDtos);
		return loginResponse;
	}

	private LoginDto toLoginDto(UserEntity user) {
		LoginDto loginDto = new LoginDto();
		loginDto.setEmail(user.getEmail());
		loginDto.setPassword(user.getPassword());
		return loginDto;
	}

}
