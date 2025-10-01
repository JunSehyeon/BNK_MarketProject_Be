package kr.co.bnk_marketproject_be.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminStoreDTO {
    private int id;

    // 추가 필드
    private String boardType;

    private String busname;
    private String rep;
    private String cornum;
    private String comnum;
    private String tel;
    private String manage;
    private String look;
}
