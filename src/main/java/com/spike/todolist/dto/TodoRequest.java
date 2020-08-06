package com.spike.todolist.dto;

public class TodoRequest {
    private String content;
    private Boolean status;

    public TodoRequest() {
    }

    public TodoRequest(String content, Boolean status) {
        this.content = content;
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
