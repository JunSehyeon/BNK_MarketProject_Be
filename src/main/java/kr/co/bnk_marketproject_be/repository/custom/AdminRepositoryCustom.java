package kr.co.bnk_marketproject_be.repository.custom;


import com.querydsl.core.Tuple;
import kr.co.bnk_marketproject_be.dto.PageRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminRepositoryCustom {

    public Page<Tuple> selectArticleAllForList(PageRequestDTO pageRequestDTO, Pageable pageable);
    public Page<Tuple> selectArticleAllForSearch(PageRequestDTO pageRequestDTO, Pageable pageable);

}
