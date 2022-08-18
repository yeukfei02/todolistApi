package com.donaldwu.main.responsebody;

import com.donaldwu.main.model.Task;
import lombok.Data;

import java.util.List;

@Data
public class GetAllTaskResponseBody {
    private String message;
    private List<Task> tasks;
}
