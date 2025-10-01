package kr.co.bnk_marketproject_be.repository;

import kr.co.bnk_marketproject_be.entity.AdminInquiry;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminInquiryRepository extends JpaRepository<AdminInquiry, Long> {

    // 최근 5건 (CREATED_AT이 문자열이면 PK 역순을 권장)
    List<AdminInquiry> findByBoardTypeOrderByIdDesc(String boardType, Pageable pageable);

    // 목록 페이징용(필요시)
    List<AdminInquiry> findByBoardTypeOrderByIdDesc(String boardType);
}
