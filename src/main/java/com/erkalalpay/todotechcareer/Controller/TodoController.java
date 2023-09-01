package com.erkalalpay.todotechcareer.Controller;

import com.erkalalpay.todotechcareer.Dto.TodoDTO;
import com.erkalalpay.todotechcareer.Entity.Todo;
import com.erkalalpay.todotechcareer.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    //Creating TO-DO
    @PostMapping("/create")
    public void saveTodo(@RequestBody TodoDTO todo){
        todoService.save(todo);
        System.out.println("şükür allah");

    }
    //Deleting TO-DO
    @PostMapping("/delete")
    public void deleteTodo (@RequestParam Long id){
        todoService.deleteTodo(id);
    }

    @GetMapping("deleteall")
    public void deleteAll(){
        todoService.deleteAllTodos();
    }



    //Updating TO-DO
    @PostMapping("/update")
    public TodoDTO updateTodo (@RequestParam String newTodo, @RequestParam Long id){

        TodoDTO todoDTO = todoService.updateTodos(id, newTodo);

        return todoDTO;
    }

    //Selecting all TO-DO's
    @GetMapping("/")
    public List<TodoDTO> showTodos (){
        List<Todo> todos = todoService.collectTodos();
        return todoService.convertTodostoDTOs(todos);
    }



}