package kr.co.bnk_marketproject_be.controller;

import kr.co.bnk_marketproject_be.dto.PageRequestDTO;
import kr.co.bnk_marketproject_be.dto.PageResponseAdminMemberDTO;
import kr.co.bnk_marketproject_be.service.AdminMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AdminMemberController {

    private final AdminMemberService adminMemberService;

    @GetMapping("/admin/member/list")
    public String adminStoreList(Model model, PageRequestDTO pageRequestDTO) {

        PageResponseAdminMemberDTO pageResponseDTO = adminMemberService.findAdminMemberAll(pageRequestDTO);

        model.addAttribute("pageResponseDTO", pageResponseDTO);

        return "admin/admin_member_list";
    }


    @GetMapping("/admin/member/search")
    public String adminStoreSearch(PageRequestDTO pageRequestDTO, Model model){

        log.info("pageRequestDTO:{}",pageRequestDTO);

        PageResponseAdminMemberDTO pageResponseDTO = adminMemberService.findAdminMemberAll(pageRequestDTO);
        model.addAttribute("pageResponseDTO", pageResponseDTO);

        return "admin/admin_member_searchList";
    }

}