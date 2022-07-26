package com.donaldwu.main.responsebody;

import com.donaldwu.main.entity.TaskEntity;
import lombok.Data;

import java.util.List;

@Data
public class GetAllTaskResponseBody {
    private String message;
    private List<TaskEntity> tasks;
}
