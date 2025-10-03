package kr.co.bnk_marketproject_be.repository;

import kr.co.bnk_marketproject_be.entity.CSNotice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CSNoticeRepository extends JpaRepository<CSNotice, Integer> {
    Page<CSNotice> findByCategory(String category, Pageable pageable);
}