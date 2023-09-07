package com.erkalalpay.todotechcareer.Repository;

import com.erkalalpay.todotechcareer.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface TodoRepository extends JpaRepository <Todo, Long> {

    Todo getById(Long id);

}