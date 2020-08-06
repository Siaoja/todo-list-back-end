package com.spike.todolist.integrationtest;

import com.spike.todolist.controller.TodoController;
import com.spike.todolist.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    TodoRepository todoRepository;

    @Test
    void should_when_given() {
        //given

        //when

        //then
    }
}
