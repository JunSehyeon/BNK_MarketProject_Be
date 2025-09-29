package kr.co.bnk_marketproject_be.controller;

import kr.co.bnk_marketproject_be.dto.AdminMemberDTO;
import kr.co.bnk_marketproject_be.entity.AdminMember;
import kr.co.bnk_marketproject_be.service.AdminMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AdminMemberController {

    private final AdminMemberService adminMemberService;

    @GetMapping("/admin/member/list")
    public String list(Model model) {
        java.util.List<AdminMemberDTO> dtoList = adminMemberService.getAllmember();
        model.addAttribute("dtoList", dtoList);
        return "admin/admin_member_list";
    }
}
