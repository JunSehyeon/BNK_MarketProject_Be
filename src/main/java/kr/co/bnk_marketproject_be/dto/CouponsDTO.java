package kr.co.bnk_marketproject_be.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponsDTO {

    private int id;
    private int users_id;
    private String code;
    private String discount_type;
    private int discount_value;

    private LocalDateTime valid_from;
    private LocalDateTime valid_to;

    private String status;
    private String coupon_name;
    private int issuecount;
    private int usercount;

    private LocalDateTime created_at;

    // 추가 필드 - name(users) - 발급자
    private String name;

}
