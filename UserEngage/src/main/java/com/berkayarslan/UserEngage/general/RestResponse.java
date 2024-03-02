package com.berkayarslan.UserEngage.general;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RestResponse<T>{

    private T data;
    private LocalDateTime responseDate;
    private boolean isSuccess;
    private String message;

    public RestResponse(T data, boolean isSuccess) {
        this.data = data;
        this.responseDate = LocalDateTime.now();
        this.isSuccess = isSuccess;
    }

    public static <T> RestResponse<T> of(T t){
        return new RestResponse<>(t,true);
    }

    public static <T> RestResponse<T> error(T t){
        return new RestResponse<>(t,false);
    }

    public static <T> RestResponse<T> empty(){
        return new RestResponse<>(null, true);
    }
}
