package com.sti.myspringboot.util;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
public class ApiResponse <T>{

    private String status;
    private Object message;
    private LocalDateTime timeStamp;

    public ApiResponse(String status, Object message) {
        this.status = status;
        this.message = message;
        this.timeStamp = LocalDateTime.now();
    }

    public static <T> ApiResponse<T> error(String status, Object message){
        return new ApiResponse<>(status, message);
    }



}
