package com.spike.todolist.service;

import com.spike.todolist.entity.Todo;
import com.spike.todolist.repository.TodoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class TodoServiceTest {
    private TodoRepository todoRepository;
    private TodoService todoService;
    private List<Todo> todos;

    @BeforeEach
    public void setUp() throws Exception {
        todoRepository = mock(TodoRepository.class);
        todoService = new TodoService(todoRepository);
        todos = new ArrayList<>();
        todos.add(new Todo(1,"text1",false));
        todos.add(new Todo(2,"text2",false));
        todos.add(new Todo(3,"text3",false));
    }

    @Test
    void should_return_todos_when_get_all_given_none(){
        //given
        given(todoRepository.findAll()).willReturn()

        //when

        //then
    }
}
