package com.donaldwu.main.responsebody;

import java.util.Map;

public class GetTaskByIdResponseBody {
    private String message;
    private Map<String, Object> task;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getTask() {
        return task;
    }

    public void setTask(Map<String, Object> taskValue) {
        task = taskValue;
    }
}
