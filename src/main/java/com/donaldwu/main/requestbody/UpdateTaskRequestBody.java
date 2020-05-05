package com.donaldwu.main.requestbody;

public class UpdateTaskRequestBody {
    private String taskMessage;
    private Long userId;

    public String getTaskMessage() {
        return taskMessage;
    }

    public void setTaskMessage(String taskMessage) {
        this.taskMessage = taskMessage;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
