package kr.co.bnk_marketproject_be.service;

import org.springframework.transaction.annotation.Transactional;
import kr.co.bnk_marketproject_be.dto.AdminOpsStatsDTO;
import kr.co.bnk_marketproject_be.repository.AdminStatsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AdminStatsService {

    private final AdminStatsRepository repo;

    @Transactional(readOnly = true)
    public AdminOpsStatsDTO getOpsStats(LocalDateTime startAt, LocalDateTime endAt) {
        long pending  = repo.countPendingPayment(startAt, endAt);
        long ready    = repo.countShippingReady(startAt, endAt);
        long cancel   = repo.countCancelRequest(startAt, endAt);
        long exch     = repo.countExchangeRequest(startAt, endAt);
        long ret      = repo.countReturnRequest(startAt, endAt);
        long orders   = repo.countOrders(startAt, endAt);
        long amount   = repo.sumOrderAmount(startAt, endAt);
        long signups  = repo.countUserSignups(startAt, endAt);
        long qna      = repo.countQna(startAt, endAt);

        return AdminOpsStatsDTO.builder()
                .pendingPayment(pending)
                .shippingReady(ready)
                .cancelRequest(cancel)
                .exchangeRequest(exch)
                .returnRequest(ret)
                .orderCount(orders)
                .orderAmount(amount)
                .userSignups(signups)
                .visitors(0)   // 추후 방문자 집계 붙이면 교체
                .qnaCount(qna)
                .build();
    }

}
