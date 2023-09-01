package com.erkalalpay.todotechcareer.Dto;


import lombok.Data;

@Data
public class TodoDTO {

    private Long id;
    private String todo;
    private Boolean isCompleted=false;
}
