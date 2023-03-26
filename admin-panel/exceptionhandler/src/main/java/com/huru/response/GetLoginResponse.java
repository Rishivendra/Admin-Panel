package com.huru.response;

import com.huru.dto.LoginDto;

public class GetLoginResponse extends AbstractLoginResponse {

	private LoginDto loginDto;

	public LoginDto getLoginDto() {
		return loginDto;
	}

	public void setLoginDto(LoginDto loginDto) {
		this.loginDto = loginDto;
	}

}
