package com.backend.gini.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "member")
public class MemberEntity extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "m_idx")
    private int mIdx;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    private String role;

    private String email;

    private String image;

    private String mPhone;
}
