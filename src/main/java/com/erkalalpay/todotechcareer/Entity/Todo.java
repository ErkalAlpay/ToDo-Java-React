package com.erkalalpay.todotechcareer.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


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
    @Column(name ="checked_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkedTime;

}