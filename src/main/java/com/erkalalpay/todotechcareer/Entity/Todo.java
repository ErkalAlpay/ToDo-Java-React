package com.erkalalpay.todotechcareer.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
public class Todo extends BaseEntity {
    @Id
    @Column(name = "todo_id")
    private Long id;
    @Column
    private String todo;
    @Column(name ="is_completed")
    private Boolean isCompleted = false;

}