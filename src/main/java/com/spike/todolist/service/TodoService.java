package com.spike.todolist.service;

import com.spike.todolist.entity.Todo;
import com.spike.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService() {
    }

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return null;
    }
}
