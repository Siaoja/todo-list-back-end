package com.spike.todolist.integrationtest;

import com.spike.todolist.controller.TodoController;
import com.spike.todolist.entity.Todo;
import com.spike.todolist.repository.TodoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    TodoRepository todoRepository;

    @BeforeEach
    void setUp() {
        todoRepository.save(new Todo(null,"todo1",false));
        todoRepository.save(new Todo(null,"todo2",false));
        todoRepository.save(new Todo(null,"todo3",false));
    }

    @AfterEach
    void tearDown() {
        todoRepository.deleteAll();
    }


    @Test
    void should_return_todos_when_get_all_todos_given_none() throws Exception {

        //when then
        mockMvc.perform(get("/mytodos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }
}
