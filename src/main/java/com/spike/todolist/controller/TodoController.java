package com.spike.todolist.controller;

import com.spike.todolist.entity.Todo;
import com.spike.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {
    TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodo(){
        return todoService.getAllTodos();
    }
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Integer id){
        return todoService.getTodoById(id);
    }
    @PostMapping()
    public Todo addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }


}
