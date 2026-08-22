package com.library.backend.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//사용자가 입력한 비밀번호를 안전한 형태로 해시 처리하는 클래스입니다.
import org.springframework.stereotype.Service;

import com.library.backend.dto.UserSignupRequest;
import com.library.backend.entity.User;
import com.library.backend.repository.UserRepository;

//1. Spring이 UserService를 관리
@Service
public class UserService {

//	2. 필요한 담당자 준비
    private final UserRepository userRepository;
    //userRepository: 회원 데이터 조회 및 저장
    private final BCryptPasswordEncoder passwordEncoder;
    //passwordEncoder: 비밀번호 해시 처리

    //3. 생성자 실행
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        //Spring이 UserService를 만들면서 사용할 UserRepository를 전달해 줍니다.
        this.passwordEncoder = new BCryptPasswordEncoder();
        //그리고 비밀번호를 해시 처리할 BCryptPasswordEncoder도 생성합니다.
    }
	//4. 회원가입 요청 받기

    public Integer signup(UserSignupRequest request) {
    	
//    	5. 로그인 아이디 중복 검사
        if (userRepository.existsByLoginId(request.getLoginId())) {
            throw new IllegalArgumentException("이미 사용 중인 로그인 아이디입니다.");
        }

//        6. 이메일 중복 검사
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }
//        7. 비밀번호 해시 처리
        String encodedPassword =
                passwordEncoder.encode(request.getPassword());

//        8. User 객체 생성
        User user = new User(
                request.getLoginId(),
                request.getEmail(),
                encodedPassword,
                request.getName()
        );
//        9. DB에 회원 저장
        User savedUser = userRepository.save(user);
//        save()가 실행되면 JPA가 다음과 비슷한 SQL을 만들어 실행합니다.
        
//        10. 회원번호 반환
        return savedUser.getId();
    }
}


//request DTO
//사용자가 보낸 값을 가지고 있음
//        ↓ 값 옮기기
//User Entity
//DB의 users 테이블과 연결됨
//        ↓ save()
//UserRepository
//        ↓
//MySQL users 테이블