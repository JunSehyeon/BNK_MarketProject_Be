package kr.co.bnk_marketproject_be.repository;

import kr.co.bnk_marketproject_be.entity.AdminMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMemberRepository extends JpaRepository<AdminMember,String> {
    List<AdminMember> findByBoardType(String boardType);
}
