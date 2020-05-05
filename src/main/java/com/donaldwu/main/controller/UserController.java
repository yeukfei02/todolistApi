package com.donaldwu.main.controller;

import com.donaldwu.main.requestbody.CreateUserRequestBody;
import com.donaldwu.main.responsebody.MainResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping(value="/api")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class.toString());

    @RequestMapping(value="/user/create-user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    private MainResponseBody createUser(@RequestBody CreateUserRequestBody createUserRequestBody) {
        String username = createUserRequestBody.getUsername();
        logger.info("username = " + username);

        MainResponseBody mainResponseBody = new MainResponseBody();
        mainResponseBody.setMessage("create user");
        return mainResponseBody;
    }
}
