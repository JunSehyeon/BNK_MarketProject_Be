package kr.co.bnk_marketproject_be.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "BOARD")
public class AdminStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String busname;
    private String rep;
    private String cornum;
    private String comnum;
    private String tel;
    private String manage;
    private String look;

    // 추가 필드
    @Column(name = "BOARD_TYPE")
    private String boardType;
}
