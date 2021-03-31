package com.backend.gini.domain.global;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class Response<T> {
    private int statusCode;
    private String message;
    private T data;

    public Response(final int statusCode, final String message){
        this.statusCode = statusCode;
        this.message = message;
        this.data = null;
    }

    public static<T> Response<T> res(final int statusCode, final String message){
        return res(statusCode, message, null);
    }

    public static<T> Response<T> res(final int statusCode, final String message, final T data){
        return Response.<T>builder()
                .data(data)
                .statusCode(statusCode)
                .message(message)
                .build();
    }
}
