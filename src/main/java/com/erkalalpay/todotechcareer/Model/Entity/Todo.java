package com.erkalalpay.todotechcareer.Model.Entity;

import com.erkalalpay.todotechcareer.Base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

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