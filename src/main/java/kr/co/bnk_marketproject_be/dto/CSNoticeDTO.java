package kr.co.bnk_marketproject_be.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CSNoticeDTO {

    private int noticeid;
    private String category;
    private String title;
    private String content;
    private String status;
    private LocalDateTime createdAt;

}
