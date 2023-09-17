package com.erkalalpay.todofullstack.Model.Entity;

import com.erkalalpay.todofullstack.Base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Entity
@NoArgsConstructor
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
    @ManyToOne
    private User user;

    public Todo(String todo) {
        this.todo = todo;
    }
}