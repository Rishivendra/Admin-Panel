package com.huru.response;

import com.huru.dto.UserDto;

public class GetUserResponse extends AbstractUserResponse {
	private UserDto userDto;

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

}
