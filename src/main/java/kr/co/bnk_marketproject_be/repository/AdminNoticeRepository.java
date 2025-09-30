package kr.co.bnk_marketproject_be.repository;

import kr.co.bnk_marketproject_be.entity.AdminNotice;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminNoticeRepository extends JpaRepository<AdminNotice, Long> {

    // 날짜문자열이 'YYYY-MM-DD HH24:MI:SS' 등 정렬 가능한 포맷이면 ↓ 이거 사용
    List<AdminNotice> findByBoardTypeOrderByCreatedAtDesc(String boardType, Pageable pageable);

    // 만약 CREATED_AT 포맷이 제각각이면 ↓ 이걸로 (PK 최신순)
    List<AdminNotice> findByBoardTypeOrderByIdDesc(String boardType, Pageable pageable);
}

