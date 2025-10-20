package kr.co.bnk_marketproject_be.mapper;

import kr.co.bnk_marketproject_be.dto.CSNoticeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CSFaqMapper {

    List<CSNoticeDTO> selectFaqList(Map<String, Object> params);
    List<CSNoticeDTO> selectFaqListByType(@Param("boardType") String boardType,
                                          @Param("subType") String subType,
                                          @Param("offset") int offset,
                                          @Param("limit") int limit);
    CSNoticeDTO selectFaqView(Long id);
}

