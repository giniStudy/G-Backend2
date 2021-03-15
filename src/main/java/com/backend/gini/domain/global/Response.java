package com.backend.gini.domain.global;

import lombok.Setter;

@Setter
public class Response {
    private int status;
    private String message;
    private Object result;

    public int getStatus(){
        return status;
    }
}
