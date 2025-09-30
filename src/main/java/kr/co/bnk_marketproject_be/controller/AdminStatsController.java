// src/main/java/.../controller/AdminStatsController.java
package kr.co.bnk_marketproject_be.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import kr.co.bnk_marketproject_be.dto.AdminOpsStatsDTO;
import kr.co.bnk_marketproject_be.service.AdminStatsService;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminStatsController {

    private final AdminStatsService service;

    // 기본: 오늘 00:00 ~ 내일 00:00
    @GetMapping("/ops-stats")
    public AdminOpsStatsDTO opsStats(
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to) {

        LocalDateTime startAt = (from == null)
                ? LocalDate.now().atStartOfDay()
                : LocalDateTime.parse(from);
        LocalDateTime endAt = (to == null)
                ? LocalDate.now().plusDays(1).atStartOfDay()
                : LocalDateTime.parse(to);

        return service.getOpsStats(startAt, endAt);
    }
}
