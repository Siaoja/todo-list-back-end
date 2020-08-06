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
    public void should_return_todos_when_get_all_todos_given_none() {
        //given
        given(todoRepository.findAll()).willReturn(todos);

        //when
        List<Todo> todoList = todoService.getAllTodos();

        //then
        assertEquals(todos.size(),todoList.size());
        assertEquals(todos.get(0),todoList.get(0));
    }

    @Test
    public void should_return_todo_when_get_todo_by_id_given_id() {
        //given
        Todo todo = todos.get(1);
        int id = todo.getId();
        given(todoRepository.findById(id)).willReturn(todo);

        //when
        Todo foundtodo = todoService.getTodoById(id);

        //then
        assertEquals(todo.getId(),foundtodo.getId());
        assertEquals(todo.getStatus(),foundtodo.getStatus());
        assertEquals(todo.getContent(),foundtodo.getContent());
    }


    @Test
    void should_return_todo_when_update_todo_given_id_and_todo() {

        //given
        Todo todo = todos.get(1);
        int id = todo.getId();
        todo.setStatus(true);
        given(todoRepository.save(todo)).willReturn(todo);

        //when
        Todo updatedTodo = todoService.updateTodo(id,todo);

        //then
        assertEquals(todo.getId(),updatedTodo.getId());
        assertEquals(todo.getContent(),updatedTodo.getContent());
        assertEquals(todo.getStatus(),updatedTodo.getStatus());

    }

    @Test
    void should_return_todo_when_add_todo_given_todo() {
        //given
        Todo todo = new Todo(4,"hasaki",false);
        given(todoRepository.save(todo)).willReturn(todo);

        //when
        Todo addedTodo = todoService.addTodo(todo);

        //then
        assertEquals(todo.getId(),addedTodo.getId());
        assertEquals(todo.getContent(),addedTodo.getContent());
        assertEquals(todo.getStatus(),addedTodo.getStatus());

    }

    @Test
    void should_return_deleted_todo_when_delete_todo_given_id() {
        //given
        Todo todo = todos.get(1);
        int id = todo.getId();
        given(todoRepository.deleteById(id)).willReturn(todo);

        //when
        Todo deletedTodo = todoService.deleteTodo(id);

        //then
        assertEquals(todo.getId(),deletedTodo.getId());
        assertEquals(todo.getContent(),deletedTodo.getContent());
        assertEquals(todo.getStatus(),deletedTodo.getStatus());
    }
}
