package kr.co.bnk_marketproject_be.repository.impl;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.bnk_marketproject_be.dto.PageRequestDTO;
import kr.co.bnk_marketproject_be.entity.QAdminStore;
import kr.co.bnk_marketproject_be.entity.QUser;
import kr.co.bnk_marketproject_be.repository.custom.AdminRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Repository
public class AdminRepositoryImpl implements AdminRepositoryCustom {

    /**
     * 반드시 파일명을 AdminRepositoryImpl로 해야함.
     * 다른 이름으로 하면 QueryDSL 생성 에러가 발생됨.
     */

    private final JPAQueryFactory jpaQueryFactory;

    private QAdminStore qAdmin = QAdminStore.article;
    private QUser qUser = QUser.user;


    @Override
    public Page<Tuple> selectAdminAllForList(PageRequestDTO pageRequestDTO, Pageable pageable) {

        List<Tuple> tupleList = jpaQueryFactory.select(qAdmin, qUser.nick)
                            .from(qAdmin)
                            .join(qUser)
                            .on(qAdmin.writer.eq(qUser.usid))
                            .offset(pageable.getOffset())
                            .limit(pageable.getPageSize())
                            .orderBy(qAdmin.ano.desc())
                            .fetch();

        // 전체 게시물 개수
        long total = jpaQueryFactory.select(qAdmin.count()).from(qAdmin).fetchOne();

        return new PageImpl<Tuple>(tupleList, pageable, total);
    }

    public Page<Tuple> selectAdminAllForSearch(PageRequestDTO pageRequestDTO, Pageable pageable) {

        String searchType = pageRequestDTO.getSearchType();
        String keyword = pageRequestDTO.getKeyword();

        // 검색 타입에 따라 where 조건 표현식 생성(동적 쿼리)
        BooleanExpression expression = null;

        if(searchType.equals("title")){
            expression = qAdmin.title.contains(keyword);
        }else if(searchType.equals("content")){
            expression = qAdmin.content.contains(keyword);
        }else if(searchType.equals("writer")){
            expression = qUser.nick.contains(keyword);
        }

        List<Tuple> tupleList = jpaQueryFactory.select(qAdmin, qUser.nick)
                .from(qAdmin)
                .join(qUser)
                .on(qAdmin.writer.eq(qUser.usid))
                .where(expression)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(qAdmin.ano.desc())
                .fetch();

        // 전체 게시물 개수
        long total = jpaQueryFactory
                .select(qAdmin.count())
                .from(qAdmin)
                .join(qUser)
                .on(qAdmin.writer.eq(qUser.usid))
                .where(expression)
                .fetchOne();

        return new PageImpl<Tuple>(tupleList, pageable, total);
    }
}
