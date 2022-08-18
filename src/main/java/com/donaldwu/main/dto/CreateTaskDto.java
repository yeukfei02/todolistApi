package com.donaldwu.main.dto;

import lombok.Data;

@Data
public class CreateTaskDto {
    private String taskMessage;
    private Long user_id;
}
