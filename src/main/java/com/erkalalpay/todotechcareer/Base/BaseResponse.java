package com.erkalalpay.todotechcareer.Base;

import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

@Data
public class BaseResponse <T>{
    private boolean isSuccess;
    private ArrayList<String> messages = new ArrayList<>();
    private T data;

    public static <T> ResponseEntity<BaseResponse<T>> ok(T data, Integer statusCode) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setSuccess(true);
        response.setData(data);
        return ResponseEntity.status(statusCode).body(response);
    }

    public static <T> ResponseEntity<BaseResponse<T>> ok(T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setSuccess(true);
        response.setData(data);
        return ResponseEntity.ok(response);
    }
    public static <T> ResponseEntity<BaseResponse<T>> ok(Integer statusCode) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setSuccess(true);
        response.setData(null);
        return ResponseEntity.status(statusCode).body(response);
    }

    public static ResponseEntity<BaseResponse<?>> error(String message, Integer statusCode) {
        BaseResponse<?> response = new BaseResponse<>();
        response.setSuccess(false);
        response.getMessages().add(message);
        return ResponseEntity.status(statusCode).body(response);
    }
}
