package kr.co.bnk_marketproject_be.service;

import kr.co.bnk_marketproject_be.dto.CSNoticeDTO;
import kr.co.bnk_marketproject_be.entity.CSNotice;
import kr.co.bnk_marketproject_be.repository.CSNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CSNoticeService {

    private final CSNoticeRepository csNoticeRepository;

    // 공지사항 리스트 (최신글 5개)
    public List<CSNoticeDTO> getNoticeList() {
        return csNoticeRepository.findTop5ByStatusOrderByCreatedAtDesc("ACTIVE")
                .stream()
                .map(n -> new CSNoticeDTO(
                        n.getNotice_id(),
                        n.getCategory(),
                        n.getTitle(),
                        n.getContent(),
                        n.getStatus(),
                        n.getCreatedAt()
                ))
                .toList();
    }

    // 공지사항 상세
    public CSNoticeDTO getNoticeDetail(Integer id) {
        CSNotice n = csNoticeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("공지사항 없음"));
        return new CSNoticeDTO(
                n.getNotice_id(),
                n.getCategory(),
                n.getTitle(),
                n.getContent(),
                n.getStatus(),
                n.getCreatedAt()
        );
    }
}
