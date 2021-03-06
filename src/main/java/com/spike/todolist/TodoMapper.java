package com.spike.todolist;

import com.spike.todolist.dto.TodoRequest;
import com.spike.todolist.dto.TodoResponse;
import com.spike.todolist.entity.Todo;
import org.springframework.beans.BeanUtils;

public class TodoMapper {

    public static Todo todoRequestToTodo(TodoRequest todoRequest) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoRequest, todo);
        return todo;
    }

    public static TodoResponse todoToTodoResponse(Todo todo) {
        TodoResponse todoResponse = new TodoResponse();
        BeanUtils.copyProperties(todo,todoResponse);
        return todoResponse;
    }
}
