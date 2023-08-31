package com.erkalalpay.todotechcareer.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;


import java.util.Date;

@MappedSuperclass
@Data
public abstract class BaseEntity {

    // ID (Unique)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;


}