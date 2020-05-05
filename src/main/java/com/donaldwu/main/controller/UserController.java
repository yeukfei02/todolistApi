package com.donaldwu.main.controller;

import com.donaldwu.main.entity.UserEntity;
import com.donaldwu.main.requestbody.CreateUserRequestBody;
import com.donaldwu.main.responsebody.MainResponseBody;
import com.donaldwu.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping(value="/api")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class.toString());

    @Autowired
    private UserService userService;

    @RequestMapping(value="/user/create-user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    private MainResponseBody createUser(@RequestBody CreateUserRequestBody createUserRequestBody, UserEntity userEntity) {
        String username = createUserRequestBody.getUsername();
        if (username != null && !username.isEmpty()) {
            userService.createUser(userEntity, username);
        }

        MainResponseBody mainResponseBody = new MainResponseBody();
        mainResponseBody.setMessage("create user");
        return mainResponseBody;
    }
}
