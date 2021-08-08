package com.backend.gini.domain.boards;

import com.backend.gini.domain.BaseTimeEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "category_id")
    private Long seq;

    @Column(nullable = false)
    private String name;

    List<Board> boardList;

    @Builder
    public Category(String name) {
        this.name = name;
    }
}