package com.donaldwu.main.responsebody;

import com.donaldwu.main.entity.TaskEntity;
import lombok.Data;

@Data
public class GetTaskByIdResponseBody {
    private String message;
    private TaskEntity task;
}
