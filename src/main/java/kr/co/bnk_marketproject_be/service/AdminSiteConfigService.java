package kr.co.bnk_marketproject_be.service;

import kr.co.bnk_marketproject_be.dto.AdminSiteConfigDTO;

public interface AdminSiteConfigService {

    AdminSiteConfigDTO get();
    int upsert(AdminSiteConfigDTO dto);
    void update(AdminSiteConfigDTO dto);

}
