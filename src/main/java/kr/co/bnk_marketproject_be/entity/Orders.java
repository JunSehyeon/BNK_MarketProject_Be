package kr.co.bnk_marketproject_be.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ORDERS")
public class Orders {

    @Id
    private int id;

    private int users_id;
    private String status;
    private int total_amount;
    private String created_at;
    private String updated_at;
    private String order_code;

    // 추가 필드 - users
    @Transient
    private String userId;
    @Transient
    private String user_name;

    // 추가 필드 - payments
    @Transient
    private String method;

    // 추가 필드 - count(orders_id)
    @Transient
    private int orders_count;
}
