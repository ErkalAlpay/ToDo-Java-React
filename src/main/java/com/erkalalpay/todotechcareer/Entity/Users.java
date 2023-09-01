package com.erkalalpay.todotechcareer.Entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Users extends BaseEntity{

    private String name;

    private String email;

    List<Todo> todolar = new ArrayList<>();
}
