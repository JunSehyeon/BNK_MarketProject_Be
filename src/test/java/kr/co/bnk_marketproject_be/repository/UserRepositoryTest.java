package kr.co.bnk_marketproject_be.repository;

import kr.co.bnk_marketproject_be.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void countByEmail() {
    }

    @Test
    void countByName() {
    }

    @Test
    void countByPhone() {
    }

    @Test
    void existsByUser_id() {
        boolean result = userRepository.existsByUserId("a101");
        //boolean result = optUser.isPresent();
        System.out.println(result);
    }

    @Test
    void existsByEmail() {
    }

    @Test
    void existsByPhone() {
    }
}