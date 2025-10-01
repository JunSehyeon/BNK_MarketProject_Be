package kr.co.bnk_marketproject_be.controller;

import kr.co.bnk_marketproject_be.dto.PageRequestDTO;
import kr.co.bnk_marketproject_be.dto.PageResponseAdminPointDTO;
import kr.co.bnk_marketproject_be.service.AdminPointService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AdminPointController {

    private final AdminPointService adminPointService;

    @GetMapping("/admin/point/list")
    public String adminStoreList(Model model, PageRequestDTO pageRequestDTO) {

        PageResponseAdminPointDTO pageResponseDTO = adminPointService.findAdminPointAll(pageRequestDTO);

        model.addAttribute("pageResponseDTO", pageResponseDTO);

        return "admin/admin_point_manage";
    }

    @GetMapping("/admin/point/search")
    public String adminStoreSearch(PageRequestDTO pageRequestDTO, Model model){

        log.info("pageRequestDTO:{}",pageRequestDTO);

        PageResponseAdminPointDTO pageResponseDTO = adminPointService.findAdminPointAll(pageRequestDTO);
        model.addAttribute("pageResponseDTO", pageResponseDTO);

        return "admin/admin_point_searchList";
    }
}
