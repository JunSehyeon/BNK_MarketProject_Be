package kr.co.bnk_marketproject_be.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "BOARD")
public class AdminMember {

    @Id
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

    // 추가 필드
    @Column(name = "BOARD_TYPE")
    private String boardType;
}
