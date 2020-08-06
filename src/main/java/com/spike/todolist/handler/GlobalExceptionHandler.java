package com.spike.todolist.handler;

import com.spike.todolist.exception.NotExistTodoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({NotExistTodoException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void handlerNotExistTodoException(){

    }
}
