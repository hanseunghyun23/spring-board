package com.board.springboard.model.mapper;

import com.board.springboard.model.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //인터페이스는 미완성된 기능이므로 반드시 public
    //회원가입

    /*
    *        import org.apache.catalina.User; 사용 금지
    *       개발자가 만든 유저 dto 모델을 가져와서 사용!!
    * @Param user 웹사이트
    *  -> jsp 템플릿 name에 작성되어 있는 변수 공간 데이터
    * 컨트롤러 @RequestBody로 전달받고
    * 전달받은 데이터를 User 객체에 저장 후
    * Service로 전달받아 SQL 에 저장하겠다
    * */
    void 회원가입(User user);
    /*
    * @Param 웹사이트>JSP>Contrpller>Service에서 전달받은 클라이언트가 작성한 이메일데이터
    * @return   가 SQL DataBase 이메일 컬럼에 저장되어 있는 이메일임을 확인했다면
    *                                   존재하기 때문에 1 반환
    *                                   존재하지 않으면 0 반환
    * */



    int 이메일중복체크(String email);
    //조건 : 매개변수 = String email/ 반환타입 = User
    // 매개변수는 () 내부에서 사용하는 명칭   (자료형 매개변수 이름)
    //반환타입은 기능명칭 앞고 접근제어자 뒤에 오는 타입
    //String,int,Long,boolean 등 다양한 자료형 작성가능하며 개발자가 만들어놓은
    //class type의 자료형 또한 반환타입에 들어갈 수있다
    //외부 class 에서 기능을 사용만 하고, 기능에 대한 겨로가를 봔환할 필요가 없을 경우
    //void(=reutrn할 데이터 존재하지 않음)로 표기가능
      User 로그인(String email);

      User 조회 (String email);



}
