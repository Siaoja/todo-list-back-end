package com.spike.todolist.service;

import com.spike.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;


@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

}
