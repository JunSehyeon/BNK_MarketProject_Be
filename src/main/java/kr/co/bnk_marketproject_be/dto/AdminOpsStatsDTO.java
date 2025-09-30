package kr.co.bnk_marketproject_be.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AdminOpsStatsDTO {

    long pendingPayment;   // 입금대기
    long shippingReady;    // 배송준비
    long cancelRequest;    // 취소요청
    long exchangeRequest;  // 교환요청
    long returnRequest;    // 반품요청
    long orderCount;       // 주문건수
    long orderAmount;      // 주문금액(원)
    long userSignups;      // 회원가입 수
    long visitors;         // 방문자 수(placeholder)
    long qnaCount;         // 문의 게시물 수

}
