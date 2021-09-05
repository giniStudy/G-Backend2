package com.backend.gini.web.dto;

import com.backend.gini.domain.boards.Board;
import com.backend.gini.domain.boards.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoardDto {

    @ApiModelProperty(hidden = true)
    Long id;
    @ApiModelProperty(example = "제목")
    String title;
    @ApiModelProperty(example = "컨텐츠")
    String content;
    @ApiModelProperty(example = "카테고리 ID")
    Long categoryId;

    @ApiModelProperty(hidden = true)
    LocalDateTime createDt;
    @ApiModelProperty(hidden = true)
    LocalDateTime modifiedDt;

    public Board toBoard(Category category){
        return Board.builder().title(title).content(content).category(category).build();
    }
}
