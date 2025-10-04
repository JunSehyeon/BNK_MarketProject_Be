package kr.co.bnk_marketproject_be.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminEmployDTO {

    private int id;
    private String department;
    private String career;
    private String form;
    private String title;
    private String user_name;
    private String status;
    private LocalDateTime recruit_from;
    private LocalDateTime recruit_to;
    private LocalDateTime created_at;
}
