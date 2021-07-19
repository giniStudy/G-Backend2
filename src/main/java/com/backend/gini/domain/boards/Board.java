package com.backend.gini.domain.boards;

import com.backend.gini.domain.entity.BaseTimeEntity;
import com.backend.gini.domain.entity.CategoryEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;


@Getter
@ToString
@Entity
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "board")
public class Board extends BaseTimeEntity {

    @JsonProperty(value = "board_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardId;

    @Column(nullable = false)
    private String title;

    private String content;

    private String deleteFlag;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @Builder
    public Board(String title, String content){
        this.title = title;
        this.content = content;
    }
}