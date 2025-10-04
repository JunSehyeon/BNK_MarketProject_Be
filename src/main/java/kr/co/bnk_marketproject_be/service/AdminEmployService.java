package kr.co.bnk_marketproject_be.service;

import kr.co.bnk_marketproject_be.dto.AdminEmployDTO;
import kr.co.bnk_marketproject_be.dto.PageRequestDTO;
import kr.co.bnk_marketproject_be.dto.PageResponseAdminEmployDTO;
import kr.co.bnk_marketproject_be.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminEmployService {
    private final AdminMapper adminMapper;

    public PageResponseAdminEmployDTO selectAdminEmployAll(PageRequestDTO pageRequestDTO) {
        // MyBatis 처리
        List<AdminEmployDTO> dtoList = adminMapper.selectAllAdminEmploy(pageRequestDTO);

        int total = adminMapper.selectCountTotalAdminEmploy(pageRequestDTO);

        return PageResponseAdminEmployDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(total)
                .build();
    }

    public int selectCountTotal(PageRequestDTO pageRequestDTO) {
        return adminMapper.selectCountTotalAdminEmploy(pageRequestDTO);
    }

    // 선택삭제 구현
    public void delete(int id){
        adminMapper.deleteAdminEmploy(id);
    };
}
