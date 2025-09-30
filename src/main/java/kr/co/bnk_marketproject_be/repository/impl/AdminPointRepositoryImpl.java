package kr.co.bnk_marketproject_be.repository.impl;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.bnk_marketproject_be.dto.PageRequestDTO;
import kr.co.bnk_marketproject_be.entity.QAdminPoint;
import kr.co.bnk_marketproject_be.entity.QUser;
import kr.co.bnk_marketproject_be.repository.custom.AdminPointRepositoryCustom;
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
public class AdminPointRepositoryImpl implements AdminPointRepositoryCustom {

    /**
     * 반드시 파일명을 AdminPointRepositoryImpl로 해야함.
     * 다른 이름으로 하면 QueryDSL 생성 에러가 발생됨.
     */

    private final JPAQueryFactory jpaQueryFactory;

    private QAdminPoint qAdminPoint = QAdminPoint.adminPoint;
    private QUser qUser = QUser.user;


    @Override
    public Page<Tuple> selectAdminPointAllForList(PageRequestDTO pageRequestDTO, Pageable pageable) {

        List<Tuple> tupleList = jpaQueryFactory.select(qAdminPoint, qUser.name, qUser.user_id, qUser.email, qUser.phone, qUser.address, qUser.role)
                .from(qAdminPoint)
                .join(qUser)
                .on(qAdminPoint.users_id.eq(qUser.user_id))
                .where(qAdminPoint.boardType.eq("pointlist"))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(qAdminPoint.id.desc())
                .fetch();

        // 전체 게시물 개수
        long total = jpaQueryFactory
                .select(qAdminPoint.count())
                .from(qAdminPoint)
                .where(qAdminPoint.boardType.eq("pointlist"))
                .fetchOne();

        return new PageImpl<Tuple>(tupleList, pageable, total);
    }

    public Page<Tuple> selectAdminPointAllForSearch(PageRequestDTO pageRequestDTO, Pageable pageable) {

        String searchType = pageRequestDTO.getSearchType();
        String keyword = pageRequestDTO.getKeyword();

        // 검색 타입에 따라 where 조건 표현식 생성(동적 쿼리)
        BooleanExpression expression = null;

        log.info("searchType:{}",  searchType);
        log.info("keyword:{}",  keyword);
        if(searchType.equals("user_id")){
            expression = qUser.user_id.contains(keyword);
        }else if(searchType.equals("name")){
            expression = qUser.name.contains(keyword);
        }else if(searchType.equals("email")){
            expression = qUser.email.contains(keyword);
        }else if(searchType.equals("phone")){
            expression = qUser.phone.contains(keyword);
        }
        log.info("expression:{}", expression.toString());
        // 기본 조건: boardType = 'storelist'
        BooleanExpression boardTypeExpr = qAdminPoint.boardType.eq("pointlist");

        List<Tuple> tupleList = jpaQueryFactory.select(qAdminPoint, qUser.name, qUser.user_id, qUser.email, qUser.phone, qUser.address, qUser.role)
                .from(qAdminPoint)
                .join(qUser)
                .on(qAdminPoint.users_id.eq(qUser.user_id)) // 대표(명)과 사람이름 같으면
                .where(boardTypeExpr.and(expression))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(qAdminPoint.id.desc())
                .fetch();

        // 전체 게시물 개수
        long total = jpaQueryFactory
                .select(qAdminPoint.count())
                .from(qAdminPoint)
                .join(qUser)
                .on(qAdminPoint.users_id.eq(qUser.user_id))
                .where(boardTypeExpr.and(expression))
                .fetchOne();

        log.info("total:{}", total);
        log.info("tuplelist:{}", tupleList.toString());
        return new PageImpl<Tuple>(tupleList, pageable, total);
    }
}