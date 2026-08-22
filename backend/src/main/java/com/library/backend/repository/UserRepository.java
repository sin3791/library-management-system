//UserRepository → 회원 데이터를 DB에 넣고 꺼내는 담당자

package com.library.backend.repository;
//UserRepository.java가 repository 패키지에 속한다는 뜻입니다.

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository에는 DB에서 자주 사용하는 기능이 이미 만들어져 있습니다.
//save()       // 저장
//findById()   // ID로 조회
//findAll()    // 전체 조회
//delete()     // 삭제
//count()      // 개수 조회

import com.library.backend.entity.User;
//앞에서 만든 User Entity를 현재 파일에서 사용하기 위해 가져옵니다.
public interface UserRepository extends JpaRepository<User, Integer> {

//UserRepository가 JpaRepository의 기능을 물려받는다.
//<User, Integer> 제네릭 문법 
//JpaRepository<관리할Entity, ID자료형>
	
    boolean existsByEmail(String email);
//    이 코드는 해당 이메일을 가진 회원이 DB에 존재하는지 확인하는 메서드입니다.
    boolean existsByLoginId(String loginId);
    // 아이디 확인 
}

//JpaRepository가 기본 제공하는 기능
//→ 저장
//→ ID로 조회
//→ 전체 조회
//→ 삭제
//→ 개수 확인
//→ ID 존재 여부 확인