package com.erkalalpay.todotechcareer.Controller;

import com.erkalalpay.todotechcareer.Dto.TodoDTO;
import com.erkalalpay.todotechcareer.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;


    @PostMapping("/create")
    public void saveTodo(@RequestBody TodoDTO todo){
        todoService.save(todo);
        System.out.println("şükür allah");

    }

    @PostMapping("/update")
    public TodoDTO updateTodo (@RequestParam String newTodo, @RequestParam Long id){

        todoService.updateTodos(id, newTodo);

        return null;
    }

}