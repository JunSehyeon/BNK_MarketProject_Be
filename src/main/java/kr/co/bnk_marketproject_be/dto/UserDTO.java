package kr.co.bnk_marketproject_be.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class UserDTO {

    private int id;
    private int user_id;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;

    //@Builder.Default // 기본 초기화, 추후계획예정
    private String role;

    private String created_at;
    private String updated_at;

}
