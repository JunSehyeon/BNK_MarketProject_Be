package kr.co.bnk_marketproject_be.repository;

import kr.co.bnk_marketproject_be.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // 사용자 정의 쿼리매서드
    public User findByUserId(String userId);

    boolean existsByUserId(String userId);      // 아이디 중복 확인
    boolean existsByEmail(String email);       // 이메일 중복 확인
    boolean existsByPhone(String phone);       // 전화번호 중복 확인

    public int countByName(String name);
    public int countByEmail(String email);
    public int countByPhone(String phone);

}

