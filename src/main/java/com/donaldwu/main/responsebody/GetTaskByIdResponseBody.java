package com.donaldwu.main.responsebody;

import com.donaldwu.main.model.Task;
import lombok.Data;

@Data
public class GetTaskByIdResponseBody {
    private String message;
    private Task task;
}
