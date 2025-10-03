package kr.co.bnk_marketproject_be.service.impl;

import jakarta.transaction.Transactional;
import kr.co.bnk_marketproject_be.dto.AdminSiteConfigDTO;
import kr.co.bnk_marketproject_be.mapper.AdminSiteConfigMapper;
import kr.co.bnk_marketproject_be.service.AdminSiteConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminSiteConfigServiceImpl implements AdminSiteConfigService {

    private final AdminSiteConfigMapper siteConfigMapper;

    @Override
    public AdminSiteConfigDTO get() {
        return siteConfigMapper.selectOne();
    }

    @Transactional
    @Override
    public int upsert(AdminSiteConfigDTO dto) {
        AdminSiteConfigDTO current = siteConfigMapper.selectOne();
        if (current == null) {
            return siteConfigMapper.insert(dto); // 최초 생성
        }
        return siteConfigMapper.update(dto);     // 갱신
    }

    @Transactional
    @Override
    public void update(AdminSiteConfigDTO dto) {
        siteConfigMapper.update(dto);
    }
}
