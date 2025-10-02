package kr.co.bnk_marketproject_be.service;

import kr.co.bnk_marketproject_be.dto.CouponsDTO;
import kr.co.bnk_marketproject_be.dto.PageRequestDTO;
import kr.co.bnk_marketproject_be.dto.PageResponseAdminCouponDTO;
import kr.co.bnk_marketproject_be.dto.PageResponseDTO;
import kr.co.bnk_marketproject_be.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminCouponService {
    private final AdminMapper adminMapper;

    public PageResponseAdminCouponDTO selectCouponsAll(PageRequestDTO pageRequestDTO) {
        // MyBatis 처리
        List<CouponsDTO> dtoList = adminMapper.selectAllCoupons(pageRequestDTO);

        int total = adminMapper.selectCountTotal(pageRequestDTO);

        return PageResponseAdminCouponDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(total)
                .build();
    }

    public int selectCountTotal(PageRequestDTO pageRequestDTO) {
        return adminMapper.selectCountTotal(pageRequestDTO);
    }
}
