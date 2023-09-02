package com.erkalalpay.todotechcareer.Controller;

import com.erkalalpay.todotechcareer.Dto.TodoDTO;
import com.erkalalpay.todotechcareer.Entity.Todo;
import com.erkalalpay.todotechcareer.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService todoService;

    //Creating TO-DO
    //http://localhost:8080/create
    @PostMapping("/create")
    public void saveTodo(@RequestParam String todo){

        todoService.save(todo);


    }
    //Deleting TO-DO
    //http://localhost:8080/delete
    @PostMapping("/delete")
    public void deleteTodo (@RequestParam Long id){
        todoService.deleteTodo(id);
    }

    //Deleting All TO-DO
    //http://localhost:8080/deleteall
    @GetMapping("deleteall")
    public void deleteAll(){
        todoService.deleteAllTodos();
    }



    //Updating TO-DO
    //http://localhost:8080/update
    @PostMapping("/update")
    public TodoDTO updateTodo (@RequestParam String newTodo, @RequestParam Long id){

        TodoDTO todoDTO = todoService.updateTodos(id, newTodo);

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