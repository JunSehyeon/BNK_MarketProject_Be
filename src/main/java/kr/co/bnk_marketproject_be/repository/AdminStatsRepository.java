package kr.co.bnk_marketproject_be.repository;

import kr.co.bnk_marketproject_be.entity.AdminStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AdminStatsRepository extends JpaRepository<AdminStats, Long> {

    // ---------- 주문 상태 집계 (ORDERS) ----------
    @Query(value = """
        SELECT COUNT(*) FROM ORDERS 
        WHERE STATUS = '입금대기' AND CREATED_AT BETWEEN :startAt AND :endAt
    """, nativeQuery = true)
    long countPendingPayment(@Param("startAt") LocalDateTime startAt,
                             @Param("endAt")   LocalDateTime endAt);

    @Query(value = """
        SELECT COUNT(*) FROM ORDERS 
        WHERE STATUS = '배송준비' AND CREATED_AT BETWEEN :startAt AND :endAt
    """, nativeQuery = true)
    long countShippingReady(@Param("startAt") LocalDateTime startAt,
                            @Param("endAt")   LocalDateTime endAt);

    @Query(value = """
        SELECT COUNT(*) FROM ORDERS 
        WHERE STATUS = '취소요청' AND CREATED_AT BETWEEN :startAt AND :endAt
    """, nativeQuery = true)
    long countCancelRequest(@Param("startAt") LocalDateTime startAt,
                            @Param("endAt")   LocalDateTime endAt);

    @Query(value = """
        SELECT COUNT(*) FROM ORDERS 
        WHERE STATUS = '교환요청' AND CREATED_AT BETWEEN :startAt AND :endAt
    """, nativeQuery = true)
    long countExchangeRequest(@Param("startAt") LocalDateTime startAt,
                              @Param("endAt")   LocalDateTime endAt);

    @Query(value = """
        SELECT COUNT(*) FROM ORDERS 
        WHERE STATUS = '반품요청' AND CREATED_AT BETWEEN :startAt AND :endAt
    """, nativeQuery = true)
    long countReturnRequest(@Param("startAt") LocalDateTime startAt,
                            @Param("endAt")   LocalDateTime endAt);

    // 총 주문건수 / 총 주문금액 (기간 내)
    @Query(value = """
        SELECT COUNT(*) FROM ORDERS 
        WHERE CREATED_AT BETWEEN :startAt AND :endAt
    """, nativeQuery = true)
    long countOrders(@Param("startAt") LocalDateTime startAt,
                     @Param("endAt")   LocalDateTime endAt);

    @Query(value = """
        SELECT NVL(SUM(TOTAL_AMOUNT), 0) FROM ORDERS 
        WHERE CREATED_AT BETWEEN :startAt AND :endAt
    """, nativeQuery = true)
    long sumOrderAmount(@Param("startAt") LocalDateTime startAt,
                        @Param("endAt")   LocalDateTime endAt);

    // ---------- 보조 집계 ----------
    // 회원 가입 수 (USERS)
    @Query(value = """
        SELECT COUNT(*) FROM USERS 
        WHERE CREATED_AT BETWEEN :startAt AND :endAt
    """, nativeQuery = true)
    long countUserSignups(@Param("startAt") LocalDateTime startAt,
                          @Param("endAt")   LocalDateTime endAt);

    // 문의 게시물 수 (BOARD) – board_type 값은 환경에 맞춰 변경
    @Query(value = """
        SELECT COUNT(*) FROM BOARD 
        WHERE BOARD_TYPE = 'QNA' 
          AND CREATED_AT BETWEEN :startAt AND :endAt
    """, nativeQuery = true)
    long countQna(@Param("startAt") LocalDateTime startAt,
                  @Param("endAt")   LocalDateTime endAt);
}
