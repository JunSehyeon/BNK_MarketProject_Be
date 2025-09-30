package kr.co.bnk_marketproject_be.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "BOARD")
@Where(clause = "BOARD_TYPE = 'inquiry'")  // ← inquiry 행만
@SequenceGenerator(name = "SEQ_BOARD", sequenceName = "SEQ_BOARD", allocationSize = 1)
public class AdminInquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BOARD")
    private Long id;

    @Column(name="BOARD_TYPE", length=200, nullable = false)
    private String boardType; // 항상 "inquiry"

    @Column(name="USER_ID", length=200)
    private String userId;

    @Column(name="TITLE", length=200, nullable=false)
    private String title;

    @Lob
    @Column(name="CONTENT")
    private String content;

    @Column(name="TEL", length=50)
    private String tel;

    @Column(name="EMAIL", length=200)
    private String email;

    @Column(name="CREATED_AT")
    private String createdAt;

    @Column(name="UPDATED_AT")
    private String updatedAt;

    @Column(name="LOOK")
    private Long look;

    // (선택) 상태/비밀글/답변 컬럼 쓰는 경우 여기에 추가

    @PrePersist
    public void prePersist() {
        if (this.boardType == null) this.boardType = "inquiry";
    }
}
