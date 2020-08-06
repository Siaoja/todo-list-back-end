package com.spike.todolist.mapper;

import com.spike.todolist.TodoMapper;
import com.spike.todolist.dto.TodoRequest;
import com.spike.todolist.dto.TodoResponse;
import com.spike.todolist.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoMapperTest {

    @Test
    void should_return_todo_when_todo_request_to_todo_given_todo_request() {
        //given
        TodoRequest todoRequest = new TodoRequest("todo1",false);

        //when
        Todo todo = TodoMapper.todoRequestToTodo(todoRequest);

        //then
        assertEquals(todoRequest.getContent(),todo.getContent());
        assertEquals(todoRequest.getStatus(),todo.getStatus());
        assertEquals(null,todo.getId());
    }

    @Test
    void should_return_todo_response_when_todo_to_todo_response_given_todo() {
        //given
        Todo todo = new Todo(1,"todo1",false);

        //when
        TodoResponse todoResponse = TodoMapper.todoToTodoResponse(todo);

        //then
        assertEquals(todo.getContent(),todoResponse.getContent());
        assertEquals(todo.getStatus(),todoResponse.getStatus());
        assertEquals(todo.getId(),todoResponse.getId());
    }
}
