package com.backend.gini.web.dto;

import com.backend.gini.domain.boards.Category;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class CategoryDto {
    @ApiModelProperty(hidden = true)
    Long id;

    @ApiModelProperty(example = "카테고리명")
    String name;

    public Category toCategory(){
        return Category.builder().name(name).build();
    }
}
