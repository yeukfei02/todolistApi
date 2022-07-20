package com.donaldwu.main.requestbody;

import lombok.Data;

@Data
public class UpdateTaskRequestBody {
    private String taskMessage;
    private Long userId;
}
