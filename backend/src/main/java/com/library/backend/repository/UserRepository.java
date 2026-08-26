package com.library.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.backend.entity.User;


//UserRepository가 JpaRepository의 기능을 물려받음
public interface UserRepository
        extends JpaRepository<User, Integer> {
	
	boolean existsByLoginId(String loginId);
	
	boolean existsByEmail(String email);
}


//JpaRepository가 모든 기능을 가지고 있어서 
//save()       → 회원 저장
//findById()   → 회원번호로 조회
//findAll()    → 전체 회원 조회
//delete()     → 회원 삭제
//count()      → 회원 수 확인