package com.backend.gini.domain.boards;

import com.backend.gini.domain.BaseTimeEntity;
import com.backend.gini.web.dto.BoardDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    Category category;

    @Builder
    public Board(String title, String content, Category category){
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public BoardDto toBoardDto(){
        return BoardDto.builder().id(id).title(title).content(content).createDt(getCreateDt()).modifiedDt(getModifiedDt()).build();
    }
}