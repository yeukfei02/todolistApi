package com.donaldwu.main.responsebody;

import lombok.Data;

@Data
public class GetUserIdResponseBody {
    private String message;
    private Long user_id;
}
