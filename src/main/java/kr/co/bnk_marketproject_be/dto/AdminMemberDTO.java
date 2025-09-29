package kr.co.bnk_marketproject_be.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminMemberDTO {

    private int id;
    private String user_id;
    private String rep;
    private String gender;
    private String grade;
    private String point;
    private String email;
    private String tel;
    private String created_at;
    private String look;
}
