package kr.co.bnk_marketproject_be.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="NOTICE")

public class CSNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "NOTICE_ID")
    private int noticeid;
    private String category;
    private String title;

    @Lob
    private String content;

    private String status;

    @CreationTimestamp
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;






}
