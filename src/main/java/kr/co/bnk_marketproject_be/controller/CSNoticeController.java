
package kr.co.bnk_marketproject_be.controller;

import kr.co.bnk_marketproject_be.dto.CSNoticeDTO;
import kr.co.bnk_marketproject_be.service.CSNoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class CSNoticeController {

    private final CSNoticeService csNoticeService;

    @GetMapping("/notice/list")
    public String noticeList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(required = false) String category,
            Model model) {

        Page<CSNoticeDTO> dtoPage;

        if (category == null || category.isEmpty()) {
            dtoPage = csNoticeService.getNoticeList(page);
        } else {
            dtoPage = csNoticeService.getNoticeListByCategory(page, category);
        }

        long totalCount = dtoPage.getTotalElements();
        model.addAttribute("dtoPage", dtoPage);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("category", category); // 선택된 카테고리 뷰에서 표시용

        return "customer_service/notice/notice_list";
    }

    @GetMapping("/notice/view/{id}")
    public String noticeView(@PathVariable Integer id, Model model) {
        CSNoticeDTO dto = csNoticeService.getNoticeDetail(id);
        model.addAttribute("notice", dto);
        return "customer_service/notice/notice_view";
    }

}
