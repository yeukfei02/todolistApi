package com.donaldwu.main.requestbody;

import lombok.Data;

@Data
public class CreateTaskRequestBody {
    private String taskMessage;
    private Long userId;
}
