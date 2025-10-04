package kr.co.bnk_marketproject_be.controller;

import kr.co.bnk_marketproject_be.dto.PageRequestDTO;
import kr.co.bnk_marketproject_be.dto.PageResponseAdminEmployDTO;
import kr.co.bnk_marketproject_be.service.AdminEmployService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AdminEmployController {

    private final AdminEmployService adminCouponsNowService;

    @GetMapping("/admin/employ/list")
    public String list(Model model, PageRequestDTO pageRequestDTO) {
        PageResponseAdminEmployDTO pageResponseAdminEmployDTO = adminCouponsNowService.selectAdminEmployAll(pageRequestDTO);

        log.info("pageResponseAdminEmployDTO={}", pageResponseAdminEmployDTO);
        model.addAttribute("pageResponseDTO", pageResponseAdminEmployDTO);

        return "admin/admin_hiring";
    }

    @GetMapping("/admin/employ/search")
    public String searchList(Model model, PageRequestDTO pageRequestDTO) {
        log.info("pageRequestDTO={}", pageRequestDTO);

        PageResponseAdminEmployDTO pageResponseAdminEmployDTO = adminCouponsNowService.selectAdminEmployAll(pageRequestDTO);
        model.addAttribute("pageResponseDTO", pageResponseAdminEmployDTO);

        return "admin/admin_hiring_searchList";
    }

    @GetMapping("/admin/employ/delete")
    public String delete(int id) {
        adminCouponsNowService.delete(id);
        return "redirect:/admin/employ/list";
    }
}
