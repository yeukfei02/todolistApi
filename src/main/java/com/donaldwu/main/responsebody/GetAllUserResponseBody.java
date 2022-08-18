package com.donaldwu.main.responsebody;

import com.donaldwu.main.model.User;
import lombok.Data;

import java.util.List;

@Data
public class GetAllUserResponseBody {
    private String message;
    private List<User> users;
}
