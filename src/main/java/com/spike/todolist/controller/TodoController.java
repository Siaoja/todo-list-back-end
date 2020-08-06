package com.spike.todolist.controller;

import com.spike.todolist.entity.Todo;
import com.spike.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mytodos")
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodo(){
        List<Todo> todos = todoService.getAllTodos();
        System.out.println(todos.toString());
        return todos;
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Integer id){
        return todoService.getTodoById(id);
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Integer id, @RequestBody Todo todo){
        return todoService.updateTodo(id,todo);
    }

    @DeleteMapping("/{id}")
    public Todo deleteTodo(@PathVariable Integer id){
        return todoService.deleteTodo(id);
    }

}
