package kr.co.bnk_marketproject_be.mapper;

import kr.co.bnk_marketproject_be.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {

    // @Param : Mybatis SQL 매퍼파일(xml)에서 해당 매개변수를 참조할 수 있는 어노테이션, 반드시 선언
    public List<CouponsDTO> selectAllCoupons(@Param("pageRequestDTO") PageRequestDTO pageRequestDTO);
    public List<CouponsNowDTO> selectAllCouponsNow(@Param("pageRequestDTO") PageRequestDTO pageRequestDTO);
    public List<AdminEmployDTO> selectAllAdminEmploy(@Param("pageRequestDTO") PageRequestDTO pageRequestDTO);
    public List<AdminAnnouncementDTO> selectAllAdminAnnouncement(@Param("pageRequestDTO") PageRequestDTO pageRequestDTO);

    // 항상 동일(total 세기)
    public int selectCountTotal(@Param("pageRequestDTO") PageRequestDTO pageRequestDTO);
    public int selectCountTotalCouponsNow(@Param("pageRequestDTO") PageRequestDTO pageRequestDTO);
    public int selectCountTotalAdminEmploy(@Param("pageRequestDTO") PageRequestDTO pageRequestDTO);
    public int selectCountTotalAdminAnnouncement(@Param("pageRequestDTO") PageRequestDTO pageRequestDTO);

    // 관리자_고객센터_채용하기 선택삭제 구현
    public void deleteAdminEmploy(int id);

}