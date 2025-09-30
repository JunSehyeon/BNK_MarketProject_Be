package kr.co.bnk_marketproject_be.dto;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellerDTO {

    private int id;
    private int user_id;
    private String seller_id;
    private String brand_name;
    private String biz_registration_number;
    private String mail_order_number;

    private String created_at;
    private String updated_at;

}