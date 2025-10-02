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
public class CouponsNowDTO {

    private int id;
    private String issue_id;
    private int users_id;
    private String status;
    private String used_at;
    private int coupons_id;

}
