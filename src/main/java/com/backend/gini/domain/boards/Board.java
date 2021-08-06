package com.backend.gini.domain.boards;

import com.backend.gini.domain.BaseTimeEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;


@Getter
@ToString
@Entity
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseTimeEntity {

    @JsonProperty(value = "board_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(nullable = false)
    private String title;

    private String content;

    private String deleteFlag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Builder
    public Board(String title, String content){
        this.title = title;
        this.content = content;
    }
}