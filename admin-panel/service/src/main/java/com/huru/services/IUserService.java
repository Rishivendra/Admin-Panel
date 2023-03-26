package com.huru.services;

import com.huru.dto.UserDto;
import com.huru.response.GetUserResponse;

public interface IUserService {

	public GetUserResponse saveUser(UserDto user);

}
