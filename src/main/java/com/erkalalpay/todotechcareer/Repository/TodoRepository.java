package com.erkalalpay.todotechcareer.Repository;

import com.erkalalpay.todotechcareer.Model.Entity.Todo;
import com.erkalalpay.todotechcareer.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TodoRepository extends JpaRepository <Todo, Long> {

    Todo getById(Long id);

    List<Todo>findByUserId(Long id);

}