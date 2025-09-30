package kr.co.bnk_marketproject_be.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="USERS")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String user_id;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;

    @Builder.Default // 기본 초기화값은 뭘로?
    private String role = "member";

    @CreationTimestamp
    private String created_at;
    private String updated_at;

}