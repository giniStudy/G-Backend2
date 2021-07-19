package com.backend.gini.domain.posts;

import com.backend.gini.domain.entity.BaseTimeEntity;
import com.backend.gini.domain.entity.CategoryEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Getter
@Setter
@ToString
@Entity
@Table(name = "board")
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "board_id")
    private int boardId;

    @Column(nullable = false)
    private String title;

    private String content;

    private String deleteFlag;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
}