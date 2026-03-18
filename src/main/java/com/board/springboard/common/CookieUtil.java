package com.board.springboard.common;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 쿠키관련 기능 모음집
 * 쿠키 추가 삭제 꺼내기
 * 어느 컨트롤러에서든 주입받아 사용가능
 */
@Component
public class CookieUtil {
    //쿠키추가(HttpOnly = JS 접근 불가, 보안상 안전)
    public void 추가(HttpServletRequest res, String 이름 , String 값, int 유지시간초){
        Cookie cookie = new Cookie(이름,값);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(유지시간초);
        res.addCookie(cookie);
    }
    public void 삭제(HttpServletRequest res, String 이름){
        Cookie cookie = new Cookie(이름,"" );
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        res.addCookie(cookie);
    }
    public String 가져오기(HttpServletRequest req, String 이름){
        Cookie[] 쿠키목록 = 요청.getCookies();
        if(쿠키목록 ==null) return null;

        return Arrays.stream(쿠키목록)
                .filter(c->"access")
    }
}
