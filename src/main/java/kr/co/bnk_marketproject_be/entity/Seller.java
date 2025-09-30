package kr.co.bnk_marketproject_be.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="SELLERS")
public class Seller{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int user_id;
    private String seller_id;
    private String brand_name;
    private String biz_registration_number;
    private String mail_order_number;

    @CreationTimestamp
    private String created_at;
    private String updated_at;

}
