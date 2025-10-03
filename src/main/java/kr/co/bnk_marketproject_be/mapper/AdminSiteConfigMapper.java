package kr.co.bnk_marketproject_be.mapper;

import kr.co.bnk_marketproject_be.dto.AdminSiteConfigDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminSiteConfigMapper {
    AdminSiteConfigDTO selectOne();
    int insert(AdminSiteConfigDTO dto);
    int update(AdminSiteConfigDTO dto);
}