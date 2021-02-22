package com.backend.gini.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
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

    public void setBId(Long bid) {
        this.bid = bid;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag;
    }

    public void setUpdate_user(String update_user) {
        this.update_user = update_user;
    }

    public void setUpdate_date(LocalDateTime update_date) {
        this.update_date = update_date;
    }

    public void setReg_date(LocalDateTime reg_date) {
        this.reg_date = reg_date;
    }

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
