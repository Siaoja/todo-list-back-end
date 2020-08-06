package com.spike.todolist.exception;

public class NotExistTodoException extends Exception{
    public NotExistTodoException() {
    }

    public NotExistTodoException(String message) {
        super(message);
    }
}
