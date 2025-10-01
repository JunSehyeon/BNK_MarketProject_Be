package kr.co.bnk_marketproject_be.repository.custom;


import com.querydsl.core.Tuple;
import kr.co.bnk_marketproject_be.dto.PageRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminMemberRepositoryCustom {

    public Page<Tuple> selectAdminMemberAllForList(PageRequestDTO pageRequestDTO, Pageable pageable);
    public Page<Tuple> selectAdminMemberAllForSearch(PageRequestDTO pageRequestDTO, Pageable pageable);

}
