package kr.co.bnk_marketproject_be.service;

import kr.co.bnk_marketproject_be.dto.CSNoticeDTO;
import kr.co.bnk_marketproject_be.entity.CSNotice;
import kr.co.bnk_marketproject_be.repository.CSNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CSNoticeService {

    private final CSNoticeRepository csNoticeRepository;

    // 공지사항 리스트 (최신글 5개)
    public Page<CSNoticeDTO> getNoticeList(int page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by("createdAt").descending());
        return csNoticeRepository.findAll(pageable)
                .map(n -> new CSNoticeDTO(
                        n.getNoticeid(),
                        n.getCategory(),
                        n.getTitle(),
                        n.getContent(),
                        n.getStatus(),
                        n.getCreatedAt()
                ));
    }

    // 공지사항 상세
    public CSNoticeDTO getNoticeDetail(Integer id) {
        CSNotice n = csNoticeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("공지사항 없음"));
        return new CSNoticeDTO(
                n.getNoticeid(),
                n.getCategory(),
                n.getTitle(),
                n.getContent(),
                n.getStatus(),
                n.getCreatedAt()
        );
    }
}
