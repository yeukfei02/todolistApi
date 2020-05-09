package com.donaldwu.main.responsebody;

import java.util.List;
import java.util.Map;

public class GetAllUserResponseBody {
    private String message;
    private List<Map<String, Object>> users;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Map<String, Object>> getUsers() {
        return users;
    }

    public void setUsers(List<Map<String, Object>> users) {
        this.users = users;
    }
}
