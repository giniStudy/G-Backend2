package com.backend.gini.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long bid;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String title;

    private String content;

    @Column(nullable = false)
    private String del_flag;

    private String update_user;

    @Column(nullable = false)
    private LocalDateTime update_date;

    @Column(nullable = false)
    private LocalDateTime reg_date;

    public Long getBid() {
        return bid;
    }

    public String getWriter() {
        return writer;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDel_flag() {
        return del_flag;
    }

    public String getUpdate_user() {
        return update_user;
    }

    public LocalDateTime getUpdate_date() {
        return update_date;
    }

    public LocalDateTime getReg_date() {
        return reg_date;
    }
}
