package com.library.backend.entity;
// package 소속이라는 것을 알려

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
//이것은 Entity와 Table이라는 어노테이션을 현재 파일에서 사용할 수 있도록 가져오는 코드입니다.

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//id를 DB의 자동 증가 기본키로 만들기 위해 필요한 JPA 도구를 가져오는 코드입니다.

import jakarta.persistence.Column;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

@Entity
// 어노테이션  이 클래스는 DB 테이블과 연결할 Entity입니다.
@Table(name = "users")
//연결할 MySQL 테이블 이름이 users라고 알려줍니다.
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//GenerationType.IDENTITY = AUTO_INCREMENT 방식으로 번호를 만들어 주세요
	private Integer id;
	
	@Column(
			name = "login_id",
			nullable = false,
			unique = true,
			length = 50
	)
	private String loginId;
	//이 코드는 User 객체 안에 로그인 아이디를 보관할 공간을 만드는 필드 선언입니다.
	
	@Column(
			name = "email",
			nullable = false,
			unique = true,
			length = 255
	)
	
	private String email;
	
	@Column(
			name = "password",
			nullable = false,
			length = 255
	)
	private String password;

	@Column(
	        name = "name",
	        nullable = false,
	        length = 100
	)
	private String name;

	@CreationTimestamp
	@Column(
	        name = "created_at",
	        nullable = false,
	        updatable = false
	)
	private LocalDateTime createdAt;
	
	// JPA용 기본 생성
	protected User() {
	}
// 	회원가입용 생성자 
	public User(
	        String loginId,
	        String email,
	        String password,
	        String name) {

	    this.loginId = loginId;
	    this.email = email;
	    this.password = password;
	    this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getLoginId() {
		return loginId;
	}
	
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
}