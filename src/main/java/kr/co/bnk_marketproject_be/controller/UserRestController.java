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
        }
        catch (Exception e) {
            log.error("Register failed", e);
            return ResponseEntity.badRequest().body(Map.of("ok", false, "error", e.getMessage()));
        }
    }

    // GET /user/check-id?user_id=xxx
    @GetMapping("/check-id")
    public ResponseEntity<Map<String, Boolean>> checkId(@RequestParam("user_id") String userId) {
        boolean available = !userService.existsByUserId(userId);
        return ResponseEntity.ok(Map.of("available", available));
    }

    // GET /user/check-email?email=xxx
    @GetMapping("/check-email")
    public ResponseEntity<Map<String, Boolean>> checkEmail(@RequestParam("email") String email) {
        boolean available = !userService.existsByEmail(email);
        return ResponseEntity.ok(Map.of("available", available));
    }

    // GET /user/check-phone?phone=xxx
    @GetMapping("/check-phone")
    public ResponseEntity<Map<String, Boolean>> checkPhone(@RequestParam("phone") String phone) {
        boolean available = !userService.existsByPhone(phone);
        return ResponseEntity.ok(Map.of("available", available));
    }
}
