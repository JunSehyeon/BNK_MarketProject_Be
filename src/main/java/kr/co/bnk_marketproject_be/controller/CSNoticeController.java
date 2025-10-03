
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

    // 공지사항 리스트
    @GetMapping("/notice/list")
    public String noticeList(@RequestParam(defaultValue = "0") int page, Model model) {
        Page<CSNoticeDTO> dtoPage = csNoticeService.getNoticeList(page);
        model.addAttribute("dtoPage", dtoPage);
        return "customer_service/notice/notice_list";
    }

    // 공지사항 상세
    @GetMapping("/notice/view/{id}")
    public String noticeView(@PathVariable Integer id, Model model) {
        CSNoticeDTO dto = csNoticeService.getNoticeDetail(id);
        model.addAttribute("notice", dto);
        return "customer_service/notice/notice_view";
    }
}
