package com.erkalalpay.todotechcareer.Model.Entity;
import com.erkalalpay.todotechcareer.Base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;



@Entity
@Data
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column
    private String useremail;

    @Column
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Todo> todoList = new ArrayList<>();

}
