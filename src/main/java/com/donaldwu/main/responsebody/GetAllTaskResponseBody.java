package com.donaldwu.main.responsebody;

import java.util.List;

public class GetAllTaskResponseBody {
    private String message;
    private List<Object> tasks;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Object> getTasks() {
        return tasks;
    }

    public void setTasks(List<Object> tasks) {
        this.tasks = tasks;
    }
}
