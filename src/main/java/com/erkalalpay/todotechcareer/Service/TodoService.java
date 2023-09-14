package com.erkalalpay.todotechcareer.Service;

import com.erkalalpay.todotechcareer.Configuration.BeanConfig;
import com.erkalalpay.todotechcareer.Model.Dto.TodoDTO;
import com.erkalalpay.todotechcareer.Model.Entity.Todo;
import com.erkalalpay.todotechcareer.Model.Entity.User;
import com.erkalalpay.todotechcareer.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.*;

@Service
@CrossOrigin("*")
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private BeanConfig beanConfig;
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private UserService userService;


    //TO-DO ADD/SAVE
    public void save(String todotext, String token){
        String email = jwtTokenService.getTokenMail(token);
        User user = userService.findByEmail(email);
        Todo todo = new Todo(todotext);
        todo.setUser(user);
        todoRepository.save(todo);
    }


    //TO-DO UPDATE
    public TodoDTO updateTodos (TodoDTO e){
        Todo todo = todoRepository.getById(e.getId());
        todo.setTodo(e.getTodo());
        todo.setUpdatedTime(new Date());
        todoRepository.save(todo);
        TodoDTO todoDTO= beanConfig.modelMapperBean().map(todo, TodoDTO.class);
        return todoDTO;
    }

    //SINGLE TO-DO CHECKBOX ACTION
    public TodoDTO checkTodo(Long id){
        Todo todo = todoRepository.getById(id);
        todo.setIsCompleted(!todo.getIsCompleted());
        todo.setCheckedTime(new Date());
        todoRepository.save(todo);
        TodoDTO todoDTO= beanConfig.modelMapperBean().map(todo, TodoDTO.class);
        return todoDTO;
    }

    //FIND BY ID


    //DELETE
    public void deleteTodo (long id){
        todoRepository.deleteById(id);
    }
    //FINDING ALL TO-DO's AND PUTING ON LIST
    public List collectTodos (){
        List<Todo> todos = todoRepository.findAll();
        return todos;
    }

    //Converting Entity to Dto as a List
    public List convertTodostoDTOs(List<Todo> todoList){
        List<TodoDTO> todoDtoList = new ArrayList<>();

        for (int i = 0; i < todoList.size(); i++) {
            TodoDTO todoDTO= beanConfig.modelMapperBean().map(todoList.get(i), TodoDTO.class);
            todoDtoList.add(todoDTO);
        }

        //SORTING LIST BY ID
        Collections.sort(todoDtoList, Comparator.comparingLong(TodoDTO::getId));
        return todoDtoList;
    }

    public void deleteAllTodos(){
        todoRepository.deleteAll();
    }



}