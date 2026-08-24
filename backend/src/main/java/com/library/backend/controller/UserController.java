// 이 클래스가 com.library.backend.controller 패키지에 속한다는 뜻입니다.
// BackendApplication이 com.library.backend에 있으므로
// Spring이 그 아래에 있는 controller 패키지도 자동으로 찾아봅니다.
package com.library.backend.controller;


// HTTP 상태 코드를 사용할 수 있게 가져옵니다.
// 예: 200 OK, 201 Created, 400 Bad Request
import org.springframework.http.HttpStatus;


// 상태 코드와 응답 내용을 함께 담는
// ResponseEntity 클래스를 사용할 수 있게 가져옵니다.
import org.springframework.http.ResponseEntity;


// POST 방식의 요청 주소를 지정하는
// @PostMapping을 사용할 수 있게 가져옵니다.
import org.springframework.web.bind.annotation.PostMapping;


// HTTP 요청 본문의 JSON을 읽는
// @RequestBody를 사용할 수 있게 가져옵니다.
import org.springframework.web.bind.annotation.RequestBody;


// Controller의 공통 요청 주소를 지정하는
// @RequestMapping을 사용할 수 있게 가져옵니다.
import org.springframework.web.bind.annotation.RequestMapping;


// 이 클래스를 웹 요청 처리용 Controller로 등록하는
// @RestController를 사용할 수 있게 가져옵니다.
import org.springframework.web.bind.annotation.RestController;


// 회원가입 요청 데이터를 담는 DTO를 가져옵니다.
import com.library.backend.dto.UserSignupRequest;


// 실제 회원가입 업무를 처리하는 UserService를 가져옵니다.
import com.library.backend.service.UserService;


// DTO에 작성한 @NotBlank, @Size, @Email 등의
// 검증 규칙을 실행하는 @Valid를 가져옵니다.
import jakarta.validation.Valid;



// 3. Spring이 UserController 클래스를 찾습니다.
//
// @RestController의 의미:
// "이 클래스에는 웹 요청을 처리하는 메서드가 있습니다."
//
// Spring이 애플리케이션을 시작할 때
// UserController 객체를 만들어 관리합니다.
@RestController


// 5. 이 Controller의 공통 주소를 등록합니다.
//
// 아래에 있는 @PostMapping("/signup")과 합치면
// 최종 주소는 /api/users/signup이 됩니다.
@RequestMapping("/api/users")


// UserController 클래스가 시작됩니다.
//
// public:
// 다른 곳에서도 이 클래스를 사용할 수 있다는 뜻입니다.
//
// class:
// UserController라는 새로운 클래스 설계도를 만든다는 뜻입니다.
public class UserController {


    // 회원가입 업무를 맡길 UserService를 보관하는 변수입니다.
    //
    // private:
    // UserController 내부에서만 사용합니다.
    //
    // final:
    // 생성자에서 한 번 받은 UserService를
    // 다른 객체로 바꾸지 않겠다는 뜻입니다.
    private final UserService userService;


    // 2, 4. Spring이 UserService를 준비해서
    // UserController에 넣어주는 생성자입니다.
    //
    // UserController 객체를 만들려면 UserService가 필요하므로,
    // Spring은 자신이 관리하는 UserService 객체를 찾아서 전달합니다.
    public UserController(UserService userService) {

        // 오른쪽 userService:
        // Spring이 생성자에 전달한 UserService 객체
        //
        // 왼쪽 this.userService:
        // 현재 UserController가 가지고 있는 변수
        //
        // 즉, Spring이 전달한 UserService를
        // 현재 Controller의 변수에 보관합니다.
        this.userService = userService;
    }


    // 5. POST /api/users/signup 주소를 등록합니다.
    //
    // @RequestMapping("/api/users")
    //              +
    // @PostMapping("/signup")
    //              =
    // POST /api/users/signup
    //
    // 6. React나 Postman이 이 주소로
    // 회원가입 JSON을 보냅니다.
    //
    // 7. Spring은 POST 방식과 주소를 확인한 후
    // 바로 아래의 signup() 메서드를 처리 담당자로 선택합니다.
    @PostMapping("/signup")


    // 회원가입 요청을 처리하는 Controller 메서드입니다.
    //
    // public:
    // Spring이 이 메서드를 호출할 수 있습니다.
    //
    // ResponseEntity<Integer>:
    // 이 메서드가 Integer 값을 body에 담을 수 있는
    // HTTP 응답 객체를 반환한다는 뜻입니다.
    //
    // signup:
    // 메서드 이름입니다. signup은 회원가입이라는 뜻입니다.
    //
    // UserSignupRequest request:
    // 회원가입 요청 데이터가 담긴 DTO 객체입니다.
    public ResponseEntity<Integer> signup(

            // 8. @RequestBody가 HTTP 요청 본문의 JSON을 읽어서
            // UserSignupRequest 객체로 변환합니다.
            //
            // 예:
            // JSON의 loginId → DTO의 loginId
            // JSON의 email   → DTO의 email
            //
            // 9. DTO 변환이 끝나면 @Valid가
            // UserSignupRequest에 적힌 검증 규칙을 실행합니다.
            //
            // 검사하는 규칙:
            // @NotBlank → 값이 비어 있지 않은가?
            // @Size     → 글자 수가 조건에 맞는가?
            // @Email    → 이메일 형식이 맞는가?
            //
            // 검사를 통과해야 아래 메서드 내부가 실행됩니다.
            //
            // 검사에 실패하면:
            // - 메서드 내부가 실행되지 않습니다.
            // - UserService로 가지 않습니다.
            // - DB에 저장되지 않습니다.
            // - 일반적으로 400 Bad Request가 응답됩니다.
            @Valid @RequestBody UserSignupRequest request) {


        // 10. DTO 검사를 통과하면 이 줄이 실행됩니다.
        //
        // userService.signup(request):
        // DTO에 담긴 회원가입 정보를 UserService에 전달하고
        // Service의 signup() 메서드를 실행합니다.
        //
        // UserService에서는 다음 순서로 처리합니다.
        // 1) 로그인 아이디 중복 검사
        // 2) 이메일 중복 검사
        // 3) 비밀번호 BCrypt 해시 처리
        // 4) User Entity 생성
        // 5) userRepository.save(user) 실행
        // 6) MySQL users 테이블에 저장
        // 7) 저장된 회원번호 반환
        //
        // Integer:
        // 정수를 담는 자료형입니다.
        //
        // userId:
        // Service에서 반환한 회원번호를 담는 변수입니다.
        //
        // 예를 들어 DB에서 만든 회원번호가 7이면
        // userId에는 7이 들어갑니다.
        Integer userId = userService.signup(request);


        // 11. 회원가입 처리 결과를 담은
        // ResponseEntity 객체를 만들어 Spring에 반환합니다.
        //
        // return:
        // 현재 signup() 메서드를 끝내고
        // 완성된 결과를 Spring에 돌려줍니다.
        //
        // Controller가 반환한 ResponseEntity를 보고
        // Spring이 실제 HTTP 응답을 만들어 React에 보냅니다.
        return ResponseEntity

                // HTTP 응답 상태를 201 Created로 설정합니다.
                //
                // 의미:
                // "요청이 성공했고 새로운 회원 데이터가 생성되었습니다."
                //
                // 정상 회원이라는 뜻이 아니라
                // 새로운 데이터 생성에 성공했다는 뜻입니다.
                .status(HttpStatus.CREATED)

                // HTTP 응답 본문에 회원번호를 넣습니다.
                //
                // userId가 7이라면 응답 본문에는 7이 들어갑니다.
                //
                // body는 MySQL에 저장하는 곳이 아니라
                // React에 보낼 응답 내용을 담는 곳입니다.
                .body(userId);
    }
}