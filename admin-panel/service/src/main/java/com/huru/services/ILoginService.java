package com.huru.services;

import com.huru.dto.LoginDto;
import com.huru.response.GetLoginResponse;

public interface ILoginService {

	GetLoginResponse authenticateUser(LoginDto loginDto);

}
