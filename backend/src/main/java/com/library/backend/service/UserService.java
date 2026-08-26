package com.library.backend.service;
import com.library.backend.repository.UserRepository;
import com.library.backend.dto.UserSignupRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {
//	UserRepository 가져오기
	
	
	//	로그인 아이디 중복 확인
	// request는 지금 없고 나중에 signup 메소드의 매개변수 선언예정 
	if (userRepository.existsByLoginId(request.getLoginId())) {
	    throw new IllegalArgumentException("이미 사용 중인 로그인 아이디입니다.");
	}
	
//	이메일 중복 확인
	if (userRepository.existsByEmail(request.getEmail())) {
	    throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
	}

	
//	비밀번호 암호화
	
	
//	User Entity 생성
//	Repository로 DB 저장
//	저장된 사용자의 ID 반환
}

