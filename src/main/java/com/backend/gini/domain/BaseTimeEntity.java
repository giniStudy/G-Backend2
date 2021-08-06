package com.backend.gini.domain;

import com.backend.gini.config.LocalDateTimeAttributeConverter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseTimeEntity {
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @CreatedDate
    private LocalDateTime createDt;

    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @LastModifiedDate
    private LocalDateTime modifiedDt;
}
