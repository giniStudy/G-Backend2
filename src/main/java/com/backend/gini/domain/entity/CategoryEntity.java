package com.backend.gini.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "category_id")
    private Integer categoryId;

    @Column(nullable = false)
    private String name;

    @Builder
    public CategoryEntity(String name) {
        this.name = name;
    }
}