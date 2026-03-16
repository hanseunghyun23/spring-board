package com.board.springboard.common;

/**
 * JwtUtil
 * JwtFilter JwtProvider 를 만든 이유
 * -> AI Blog에서 알려주는 방식 수만가지
 * -> 예전부터 최신 서치를 했을 때 가장 많이 사용 오랜된 추천!
 * JwtFrilter JwtProvider 해라 -> JwtUtil 합쳐서 가볍게 작성 가능
 */

/**
 * JWT 관련 기능을 모아놓은 클래스
 *
 * 1. 토큰만들기 : createAccessToken(), createRefreshToken()
 * 2. 토큰 읽기: getEmail(), isValid()
 * 3. 요청 필터링 : 내부 클래스 JwtFilter(매 요청마다 토큰 확인)
 */

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

import java.util.Date;

import static java.lang.StringUTF16.getBytes;

@Slf4j
@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String 시크릿키값;

    @Value("${jwt.access-expiry}")
    private String 엑세스토큰만료시간;

    @Value("${jwt.refresh-expiry}")
    private String 리프레시토큰만료시간;

    private SecretKey 키;

    @PostConstruct
    public void 초기화(){
        this.키 = Keys.hmacShaKeyFor(시크릿키값,getBytes());

        //토큰만들기

        //액세스 토큰 발급 (30분 짜리) 사이트에 움직임이 있으면 30분 초기화 매번 진행


    }
    public String 액세스토큰만들기(String email){
        return 토큰빌드(email.액세스토큰만료기간);
    }
    public String 리프레시토큰만들기(String email){
        return 토큰빌드(email.리프레시토큰만료기간);
    }
    private String 토큰빌드(String email, long 만료시간ms){
    Date 지금 = new Date();
    return Jwts.builder()
            .subject(email)                                 //트큰 안에 이메일 저장
             .issuedAt(지금)                                  //발급시각
            .expiration(new Date(지금.getTime() + 만료시간ms)) //만료시각
            .signWith(키)                                      //서명(위변조 방지)
    .conpact();}
    //토큰읽기
    //토큰에서 이메일 꺼내기
    public String 이메일가져오기(String token){
        return 토큰파싱(token).getSubject();
    }
    //토큰이 유효한지 확인(true = 정상/ false = 만료 or 변조)
    public boolean 유효토큰인지확인하는기능(String token){
        try{

        }catch (JwtException | IllegalArgumentException e){
            log.debug("토큰 검증 실패 : {}",e.getMessage());
            return false;
        }
    }

}
