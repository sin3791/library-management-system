//MySQL에 작성한 테이블을 Spring Boot에서 Java 객체로 사용하기 위해 만드는 클래스가 Entity입니다.

package com.library.backend.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//
//@Entity  → 이 클래스는 DB와 연결할 클래스다
//@Table   → 이 DB 테이블과 연결한다
//@Column  → 이 필드는 이 DB 컬럼과 연결한다
//JPA      → 위 설명을 이용해 Java 객체와 DB를 연결하는 표준
//Hibernate → 설명을 읽고 실제 SQL을 만들어 실행
//
//@GeneratedValue
//→ ID 값을 자동으로 생성하라고 JPA에 알려주는 어노테이션
//
//GenerationType
//→ ID를 어떤 방식으로 자동 생성할지 정하는 선택값

@Entity
//이 클래스가 DB와 연결되는 클래스라고 JPA에 알려줍니다.
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // 회원번호
    @Column(nullable = false, unique = true, length = 255)
    private String email;
    // 이메일
    @Column(nullable = false, length = 255)
    private String password;
    // 비밀번호
    @Column(nullable = false, length = 100)
    private String name;
    // 이름
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    // 가입 시간
    
    protected User() {
    }

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public Integer getId() {
        return id;
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

//
//1. User 클래스와 users 테이블 연결
//2. 테이블 컬럼에 대응하는 필드 선언
//3. User 객체를 만드는 생성자
//4. 저장된 값을 읽는 getter