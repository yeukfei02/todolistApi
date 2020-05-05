package com.donaldwu.main.responsebody;

import java.util.List;

public class GetAllUserResponseBody {
    private String message;
    private List<Object> users;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Object> getUsers() {
        return users;
    }

    public void setUsers(List<Object> users) {
        this.users = users;
    }
}
