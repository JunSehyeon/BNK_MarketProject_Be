package kr.co.bnk_marketproject_be.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Transient;
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

    // 추가 필드 - 페이지네이션
    @Transient
    private String name;
    @Transient
    private String user_id;
    @Transient
    private String email;
    @Transient
    private String phone;
    @Transient
    private String address;
    @Transient
    private String role;

    public void setName(String name) {
        this.name = name;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
