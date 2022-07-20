package com.donaldwu.main.responsebody;

import lombok.Data;

import java.util.Map;

@Data
public class GetTaskByIdResponseBody {
    private String message;
    private Map<String, Object> task;
}
