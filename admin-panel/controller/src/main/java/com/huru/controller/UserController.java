package com.huru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huru.api.response.ApiResponse;
import com.huru.constraints.Constraints;

import com.huru.request.GetLoginRequest;
import com.huru.request.GetUserRequest;
import com.huru.response.GetLoginResponse;

import com.huru.response.GetUserResponse;
import com.huru.services.ILoginService;
import com.huru.services.IUserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private ILoginService loginService;

	@PostMapping(Constraints.SIGNUP)
	public ApiResponse<GetUserResponse> signup(@RequestBody GetUserRequest userRequest) {
		GetUserResponse userResponse = userService.saveUser(userRequest.getUserDto());
		return new ApiResponse<>(HttpStatus.OK.value(), Constraints.USER_SIGNUP, userResponse);
	}

	@PostMapping(Constraints.SIGNIN)
	public ApiResponse<GetLoginResponse> authenticateUser(@RequestBody GetLoginRequest loginRequest,
			HttpSession session) {
		GetLoginResponse loginResponse = loginService.authenticateUser(loginRequest.getLoginDto());
		session.setAttribute("email", loginResponse.getLoginDto().getEmail());
		return new ApiResponse<>(HttpStatus.OK.value(), Constraints.USER_SIGNIN, loginResponse);
	}

	@PostMapping(Constraints.SIGNOUT)
	public ApiResponse<String> logout(HttpSession session) {
		// Invalidate session
		session.invalidate();
		return new ApiResponse<>(HttpStatus.OK.value(), Constraints.USER_SIGNOUT, null);
	}

}
