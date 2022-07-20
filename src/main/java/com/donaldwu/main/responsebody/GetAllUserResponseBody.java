package com.donaldwu.main.responsebody;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class GetAllUserResponseBody {
    private String message;
    private List<Map<String, Object>> users;
}
