package kr.co.bnk_marketproject_be.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "BOARD")
@Where(clause = "BOARD_TYPE = 'notice'")   // ← 이 엔티티는 notice 행만 바라봄
@SequenceGenerator(name = "SEQ_BOARD", sequenceName = "SEQ_BOARD", allocationSize = 1)
public class AdminNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BOARD")
    private Long id;

    @Column(name="BOARD_TYPE", length=200, nullable = false)
    private String boardType; // 항상 "notice"

    @Column(name="USER_ID", length=200)
    private String userId;

    @Column(name="TITLE", length=200, nullable=false)
    private String title;

    @Lob
    @Column(name="CONTENT")
    private String content;

    @Column(name="CREATED_AT")
    private String createdAt;

    @Column(name="UPDATED_AT")
    private String updatedAt;

    @Column(name="LOOK")
    private Long look;

    @PrePersist
    public void prePersist() {
        if (this.boardType == null) this.boardType = "notice";
    }
}
