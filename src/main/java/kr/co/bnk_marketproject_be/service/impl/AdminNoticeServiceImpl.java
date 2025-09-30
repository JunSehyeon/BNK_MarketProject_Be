package kr.co.bnk_marketproject_be.service.impl;

import kr.co.bnk_marketproject_be.dto.AdminNoticeDTO;
import kr.co.bnk_marketproject_be.entity.AdminNotice;
import kr.co.bnk_marketproject_be.repository.AdminNoticeRepository;
import kr.co.bnk_marketproject_be.service.AdminNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminNoticeServiceImpl implements AdminNoticeService {

    private final AdminNoticeRepository repo;

    @Override
    public List<AdminNoticeDTO> getLatest(int limit) {
        var page = PageRequest.of(0, limit);

        // CREATED_AT 컬럼이 VARCHAR2이므로 정렬은 PK(ID) 역순으로 하는 게 안전
        var list = repo.findByBoardTypeOrderByIdDesc("NOTICE", page);

        return list.stream()
                .map(n -> AdminNoticeDTO.builder()
                        .id(n.getId())
                        .title(n.getTitle())
                        .createdAt(n.getCreatedAt())   // 문자열 그대로 DTO에 전달
                        .build()
                )
                .toList();
    }
}
