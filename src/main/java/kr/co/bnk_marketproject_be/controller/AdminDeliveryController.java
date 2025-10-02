package kr.co.bnk_marketproject_be.controller;

import kr.co.bnk_marketproject_be.dto.PageRequestDTO;
import kr.co.bnk_marketproject_be.dto.PageResponseAdminDeliveryDTO;
import kr.co.bnk_marketproject_be.service.AdminDeliveryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AdminDeliveryController {

    private final AdminDeliveryService adminDeliveryService;

    @GetMapping("/admin/delivery/list")
    public String adminDeliveryList(Model model, PageRequestDTO pageRequestDTO) {

        PageResponseAdminDeliveryDTO pageResponseDTO = adminDeliveryService.findAdminDeliveryAll(pageRequestDTO);

        log.info("pageResponseDTO={}", pageResponseDTO);
        model.addAttribute("pageResponseDTO", pageResponseDTO);

        return "admin/admin_delivery";
    }

    @GetMapping("/admin/delivery/search")
    public String adminDeliverySearch(PageRequestDTO pageRequestDTO, Model model){

        log.info("pageRequestDTO:{}",pageRequestDTO);

        PageResponseAdminDeliveryDTO pageResponseDTO = adminDeliveryService.findAdminDeliveryAll(pageRequestDTO);

        log.info("pageResponseDTO={}", pageResponseDTO);
        model.addAttribute("pageResponseDTO", pageResponseDTO);

        return "admin/admin_delivery_searchList";
    }
}
