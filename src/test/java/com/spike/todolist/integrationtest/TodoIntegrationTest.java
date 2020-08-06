package com.spike.todolist.integrationtest;

import com.alibaba.fastjson.JSON;
import com.spike.todolist.controller.TodoController;
import com.spike.todolist.entity.Todo;
import com.spike.todolist.repository.TodoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    TodoRepository todoRepository;

    List<Todo> todos;

    @BeforeEach
    void setUp() {
        todos = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            todos.add(todoRepository.save(new Todo(null,"todo"+i,false)));
        }
    }

    @AfterEach
    void tearDown() {
        todoRepository.deleteAll();
    }


    @Test
    void should_return_todos_when_get_all_todos_given_none() throws Exception {

        //when then
        mockMvc.perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    void should_return_todo_when_get_todo_by_id_given_id() throws Exception {
        //given
        Todo todo = todos.get(1);
        int id = todo.getId();

        //when then
        mockMvc.perform(get("/todos/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(todo.getId()))
                .andExpect(jsonPath("$.content").value(todo.getContent()))
                .andExpect(jsonPath("$.status").value(todo.getStatus()));
    }

    @Test
    void should_return_todo_and_created_status_when_add_todo_given_todo() throws Exception {
        //given
        Todo todo = new Todo(null,"add todo",false);
        String todoInfo = JSON.toJSONString(todo);

        //when then
        mockMvc.perform(post("/todos").contentType(MediaType.APPLICATION_JSON).content(todoInfo))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.content").value(todo.getContent()))
                .andExpect(jsonPath("$.status").value(todo.getStatus()));
    }



}
