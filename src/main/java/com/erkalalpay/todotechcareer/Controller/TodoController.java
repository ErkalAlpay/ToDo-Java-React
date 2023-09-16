package com.erkalalpay.todotechcareer.Controller;

import com.erkalalpay.todotechcareer.Model.Dto.LoginResponse;
import com.erkalalpay.todotechcareer.Model.Dto.TodoDTO;
import com.erkalalpay.todotechcareer.Model.Entity.Todo;
import com.erkalalpay.todotechcareer.Model.Entity.User;
import com.erkalalpay.todotechcareer.Service.JwtTokenService;
import com.erkalalpay.todotechcareer.Service.TodoService;
import com.erkalalpay.todotechcareer.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
public class TodoController {

    @Autowired
    private TodoService todoService;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtTokenService jwtTokenService;

    //Creating TO-DO
    //http://localhost:8080/todo/create
    @PostMapping("/todo/create")
    public void saveTodo(@RequestBody TodoDTO todo){
        String todoString = todo.getTodo();
        String token = todo.getToken();
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
    @PostMapping("/todo/show")
    public List<TodoDTO> showTodos (@RequestBody LoginResponse loginResponse){
        String userEmail = jwtTokenService.getTokenMail(loginResponse.getToken());
        User user = userService.findByEmail(userEmail);
        List<Todo> todos = todoService.collectTodos(user.getId());
        return todoService.convertTodostoDTOs(todos);
    }



}