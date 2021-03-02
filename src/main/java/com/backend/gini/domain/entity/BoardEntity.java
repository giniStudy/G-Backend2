package com.backend.gini.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long bId;

    @Column(nullable = false)
    private String title;

    private String content;

    public Long getBid() {
        return bId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
