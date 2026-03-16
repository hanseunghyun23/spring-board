package com.board.springboard.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
/**
 * JWT 토큰 발급 검증
 *
 * Access Token : 30 -> 매  API 요청헤더 or 쿠키 첨부
 * Refresh Token : 14일 -> 임시저장 / 만료 시 재발급용 (=Redis 임시저장)
 *                 ConcurrentHAshHap 컴퓨터 메모리 임시 저장
 */
public class JwtFilter {

}
