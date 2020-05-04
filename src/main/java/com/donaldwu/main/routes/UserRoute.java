package com.donaldwu.main.routes;

import com.donaldwu.main.controller.UserController;
import com.donaldwu.main.requestbody.CreateUserRequestBody;

public class UserRoute {
    public static void createUser() {
        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody();
        createUserRequestBody.setUsername("test");
        UserController.createUser(createUserRequestBody);
    }
}
