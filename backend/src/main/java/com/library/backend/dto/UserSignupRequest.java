package com.library.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;


public class UserSignupRequest{
	
//	1. loginId 필드
	@NotBlank
	@Size(min = 4, max = 50)
	private String loginId;

//	2. email 필드
	@Email
	@NotBlank
	@Size(max = 255)
	private String email;

//	3. password 필드
	@NotBlank
	@Size(min = 8, max = 100)
	private String password;

//	4. name 필드
	@NotBlank
	@Size(max = 100)
	private String name;

//	5. 입력값 검증 어노테이션
// NotBlank, Size

//	6. 기본 생성자

	public UserSignupRequest() {
	}

	
//	7. getter
//	8. setter
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

