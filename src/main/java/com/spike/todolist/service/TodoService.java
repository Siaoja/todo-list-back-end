package com.spike.todolist.service;

import com.spike.todolist.entity.Todo;
import com.spike.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public TodoService() {
    }

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo updateTodo(int id, Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo getTodoById(int id) {
        return todoRepository.findById(id).orElse(null);
    }

    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo deleteTodo(int id) {
        Todo todo = getTodoById(id);
        if(todo != null)
            todoRepository.deleteById(id);
        return todo;
    }
}
