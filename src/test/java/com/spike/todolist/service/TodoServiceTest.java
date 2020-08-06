package com.spike.todolist.service;

import com.spike.todolist.entity.Todo;
import com.spike.todolist.repository.TodoRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

public class TodoServiceTest {
    @Autowired
    private TodoRepository todoRepository;
    private TodoService todoService;
    private List<Todo> todos;


    @BeforeEach
    void setUp() {
        todoRepository = Mockito.mock(TodoRepository.class);
        todoService = new TodoService(todoRepository);
        todos = new ArrayList<>();
        todos.add(new Todo(1, "text1", false));
        todos.add(new Todo(2, "text2", false));
        todos.add(new Todo(3, "text3", false));
    }

    @Test
    public void should_return_todos_when_get_all_given_none() {
        //given
        given(todoRepository.findAll()).willReturn(todos);

        //when
        List<Todo> todoList = todoService.getAllTodos();

        //then
        assertEquals(todos.size(),todoList.size());
        assertEquals(todos.get(0),todoList.get(0));
    }
}
