package com.erkalalpay.todotechcareer.Model.Dto;


import lombok.Data;

@Data
public class TodoDTO {

    private Long id;
    private String todo;
    private String token;
    private Boolean isCompleted=false;
}
