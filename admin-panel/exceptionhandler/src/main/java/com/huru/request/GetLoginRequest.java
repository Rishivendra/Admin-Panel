package com.huru.request;

import com.huru.dto.LoginDto;

public class GetLoginRequest extends AbstractLoginRequest {

	private LoginDto loginDto;

	public LoginDto getLoginDto() {
		return loginDto;
	}

	public void setLoginDto(LoginDto loginDto) {
		this.loginDto = loginDto;
	}

}
