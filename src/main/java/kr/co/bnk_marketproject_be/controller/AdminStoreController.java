package kr.co.bnk_marketproject_be.controller;

import kr.co.bnk_marketproject_be.dto.AdminStoreDTO;
import kr.co.bnk_marketproject_be.service.AdminStoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AdminStoreController {

    private final AdminStoreService adminStoreService;

    @GetMapping("/admin/shop/list")
    public String adminStoreList(Model model){
        List<AdminStoreDTO> dtoList = adminStoreService.findAdminStoreAll();
        model.addAttribute("dtoList",dtoList);
        return "admin/admin_store_list";
    }
}
