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
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String content;

    private Boolean deleteFlag = false;

    @OneToMany(mappedBy = "board_id")
    List<Category> categories;

    @Builder
    public Board(String title, String content){
        this.title = title;
        this.content = content;
    }
}