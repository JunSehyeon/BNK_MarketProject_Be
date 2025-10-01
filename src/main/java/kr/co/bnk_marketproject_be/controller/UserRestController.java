package kr.co.bnk_marketproject_be.controller;

import kr.co.bnk_marketproject_be.dto.UserDTO;
import kr.co.bnk_marketproject_be.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserRestController {

    private final UserService userService;

    // POST /user/register : 회원가입
    @PostMapping("/register")
    public ResponseEntity<Map<String,Object>> register(@RequestBody UserDTO userDTO) {
        log.info("API register request user_id={}", userDTO.getUserId());
        try {
            userService.register(userDTO);
            return ResponseEntity.ok(Map.of("success", true));
        } catch (IllegalStateException ise) {
            return ResponseEntity.badRequest().body(Map.of("success", false, "message", ise.getMessage()));
        } catch (Exception e) {
            log.error("register error", e);
            return ResponseEntity.status(500).body(Map.of("success", false, "message", "서버 오류"));
        }
    }

    // GET /user/check-id?user_id=xxx  (아이디 중복 체크)
    @GetMapping("/check-id")
    public ResponseEntity<Map<String,Boolean>> checkId(@RequestParam("user_id") String userId) {
        int count = userService.countUser("user_id", userId); // int 반환
        boolean available = (count == 0); // 0이면 사용 가능
        return ResponseEntity.ok(Map.of("available", available));
    }
}
