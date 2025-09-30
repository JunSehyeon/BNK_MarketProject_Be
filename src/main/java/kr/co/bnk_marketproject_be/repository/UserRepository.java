package kr.co.bnk_marketproject_be.repository;

import kr.co.bnk_marketproject_be.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends JpaRepository<User, String> {

    // 사용자 정의 쿼리배서드
    public int countByUser_id(int user_id);
    public int countByEmail(String email);
    public int countByName(String name);
    public int countByPhone(String phone);

}






