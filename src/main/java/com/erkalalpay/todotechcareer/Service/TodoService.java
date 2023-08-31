package com.erkalalpay.todotechcareer.Service;

import com.erkalalpay.todotechcareer.Bean.BeanConfig;
import com.erkalalpay.todotechcareer.Dto.TodoDTO;
import com.erkalalpay.todotechcareer.Entity.Todo;
import com.erkalalpay.todotechcareer.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private BeanConfig beanConfig;


    public void save(TodoDTO todoDto){
        Todo todo = beanConfig.modelMapperBean().map(todoDto, Todo.class);
        todoRepository.save(todo);

    }

    public TodoDTO updateTodos (long id, String text){

        Todo todo = todoRepository.getById(id);
        todo.setTodo(text);
        todo.setUpdatedTime(new Date());
        todoRepository.save(todo);
        TodoDTO todoDTO= beanConfig.modelMapperBean().map(todo, TodoDTO.class);
        return todoDTO;
    }



}