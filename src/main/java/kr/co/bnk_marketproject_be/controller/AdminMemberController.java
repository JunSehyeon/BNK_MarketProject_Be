package kr.co.bnk_marketproject_be.controller;

import kr.co.bnk_marketproject_be.dto.AdminMemberDTO;
import kr.co.bnk_marketproject_be.dto.PageRequestDTO;
import kr.co.bnk_marketproject_be.dto.PageResponseDTO;
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

//    @GetMapping("/admin/shop/list")
//    public String adminStoreList(Model model, PageRequestDTO pageRequestDTO) {
//
////        PageResponseDTO pageResponseDTO = adminMemberService.findAdminStoreAll(pageRequestDTO);
//
////        model.addAttribute("pageResponseDTO", pageResponseDTO);
//
//        return "admin/admin_member_list";
//    }
//
//    @GetMapping("/admin/shop/search")
//    public String adminStoreSearch(PageRequestDTO pageRequestDTO, Model model){
//
//        log.info("pageRequestDTO:{}",pageRequestDTO);
//
////        PageResponseDTO pageResponseDTO = adminMemberService.findAdminStoreAll(pageRequestDTO);
////        model.addAttribute("pageResponseDTO", pageResponseDTO);
//
//        return "admin/admin_member_searchList";
//    }
}
