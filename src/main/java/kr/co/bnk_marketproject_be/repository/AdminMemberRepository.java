package kr.co.bnk_marketproject_be.repository;

import kr.co.bnk_marketproject_be.entity.AdminMember;
import kr.co.bnk_marketproject_be.repository.custom.AdminMemberRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMemberRepository extends JpaRepository<AdminMember,String>, AdminMemberRepositoryCustom {
    List<AdminMember> findByBoardType(String boardType);
}