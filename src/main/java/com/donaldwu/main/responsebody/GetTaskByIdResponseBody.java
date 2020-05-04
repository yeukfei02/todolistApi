package com.donaldwu.main.responsebody;

public class GetTaskByIdResponseBody {
    private String message;
    private Object Task;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getTask() {
        return Task;
    }

    public void setTask(Object task) {
        Task = task;
    }
}
