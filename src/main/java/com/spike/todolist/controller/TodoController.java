package com.spike.todolist.controller;

import com.spike.todolist.entity.Todo;
import com.spike.todolist.exception.NotExistTodoException;
import com.spike.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
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
    public Todo getTodoById(@PathVariable Integer id) throws NotExistTodoException {
        return todoService.getTodoById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo addTodo(@RequestBody Todo todo){
        System.out.println("todo is:" + todo);
        return todoService.addTodo(todo);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Integer id, @RequestBody Todo todo){
        return todoService.updateTodo(id,todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Integer id) throws NotExistTodoException {
        todoService.deleteTodo(id);
    }

}
