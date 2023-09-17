package com.erkalalpay.todofullstack.Repository;

import com.erkalalpay.todofullstack.Model.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TodoRepository extends JpaRepository <Todo, Long> {

    Todo getById(Long id);

    List<Todo>findByUserId(Long id);

}