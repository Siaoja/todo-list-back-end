package com.spike.todolist.mapper;

import com.spike.todolist.TodoMapper;
import com.spike.todolist.dto.TodoRequest;
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

}
