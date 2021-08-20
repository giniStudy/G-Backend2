package com.backend.gini.domain.boards;

import com.backend.gini.domain.BaseTimeEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Category extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "id")
    private Long id;

//    @OneToMany(mappedBy = "category_id")
//    private List<Board> Board;

    @Column(nullable = false)
    private String name;

    @Builder
    public Category(String name) {
        this.name = name;
    }
}