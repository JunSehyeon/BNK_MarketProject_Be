package kr.co.bnk_marketproject_be.controller;

import kr.co.bnk_marketproject_be.service.AdminInquiryService;
import kr.co.bnk_marketproject_be.service.AdminNoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AdminMainController {

    private final AdminNoticeService adminNoticeService;
    private final AdminInquiryService adminInquiryService;

    @GetMapping("/admin/admin_main")
    public String list(Model model) {
        model.addAttribute("notices", adminNoticeService.getLatest(5));
        model.addAttribute("inquiries", adminInquiryService.latest(5));
        return "admin/admin_main";
    }
}

