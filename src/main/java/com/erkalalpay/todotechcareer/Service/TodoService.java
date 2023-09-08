package com.erkalalpay.todotechcareer.Service;

import com.erkalalpay.todotechcareer.Bean.BeanConfig;
import com.erkalalpay.todotechcareer.Dto.TodoDTO;
import com.erkalalpay.todotechcareer.Entity.Todo;
import com.erkalalpay.todotechcareer.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@CrossOrigin("*")
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private BeanConfig beanConfig;


    //TO-DO ADD/SAVE
    public void save(String todotext){
        Todo todo = new Todo();
        todo.setTodo(todotext);
        todoRepository.save(todo);
    }


    //SINGLE TO-DO UPDATE
    public TodoDTO updateTodos (long id, String text){
        Todo todo = todoRepository.getById(id);
        todo.setTodo(text);
        todo.setUpdatedTime(new Date());
        todoRepository.save(todo);
        TodoDTO todoDTO= beanConfig.modelMapperBean().map(todo, TodoDTO.class);
        return todoDTO;
    }

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

        return todoDtoList;
    }

    public void deleteAllTodos(){
        todoRepository.deleteAll();
    }



}