package com.backend.gini.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BoardsReuqest {
    @ApiModelProperty(example = "1", notes = "카테고리 이름")
    String category;
    @ApiModelProperty(example = "1", notes = "한페이지 보여줄 개수")
    Long pageSize;
    @ApiModelProperty(example = "1", notes = "현재 페이지")
    Long page;
}
