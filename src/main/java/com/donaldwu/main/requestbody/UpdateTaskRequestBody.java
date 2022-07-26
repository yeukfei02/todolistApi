package com.donaldwu.main.requestbody;

import lombok.Data;

@Data
public class UpdateTaskRequestBody {
    private String taskMessage;
    private Long user_id;
}
