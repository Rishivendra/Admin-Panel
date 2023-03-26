package com.huru.request;

import com.huru.dto.UserDto;

public class GetUserRequest extends AbstractUserRequest {
	private UserDto userDto;

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
}
