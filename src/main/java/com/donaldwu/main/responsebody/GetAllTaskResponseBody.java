package com.donaldwu.main.responsebody;

import java.util.List;
import java.util.Map;

public class GetAllTaskResponseBody {
    private String message;
    private List<Map<String, Object>> tasks;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Map<String, Object>> getTasks() {
        return tasks;
    }

    public void setTasks(List<Map<String, Object>> tasks) {
        this.tasks = tasks;
    }
}
