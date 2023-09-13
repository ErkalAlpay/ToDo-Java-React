package com.erkalalpay.todotechcareer.Controller;

import com.erkalalpay.todotechcareer.Model.Dto.TodoDTO;
import com.erkalalpay.todotechcareer.Model.Entity.Todo;
import com.erkalalpay.todotechcareer.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
public class TodoController {

    @Autowired
    private TodoService todoService;

    //Creating TO-DO
    //http://localhost:8080/create
    @PostMapping("/create")
    public void saveTodo(@RequestBody TodoDTO todo, @PathVariable String token){
        String todoString = todo.getTodo();
        todoService.save(todoString, token);

    }

    //Deleting TO-DO
    //http://localhost:8080/delete
    @PutMapping("/delete/{id}")
    public void deleteTodo (@PathVariable Long id){
        todoService.deleteTodo(id);
    }

    //Deleting All TO-DO
    //http://localhost:8080/deleteall
    @GetMapping("deleteall")
    public void deleteAll(){
        todoService.deleteAllTodos();
    }


    //Check TO-DO
    //http://localhost:8080/check
    @PutMapping("/check/{id}")
    public TodoDTO checkTodo (@PathVariable Long id){

        return todoService.checkTodo(id);
    }



    //Updating TO-DO
    //http://localhost:8080/update
    @PostMapping("/update")
    public TodoDTO updateTodo (@RequestBody TodoDTO e){

        TodoDTO todoDTO = todoService.updateTodos(e);

        return todoDTO;
    }

    //Selecting all TO-DO's
    //http://localhost:8080/
    @GetMapping("/")
    public List<TodoDTO> showTodos (){
        List<Todo> todos = todoService.collectTodos();
        return todoService.convertTodostoDTOs(todos);
    }



}