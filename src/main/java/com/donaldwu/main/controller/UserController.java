package com.donaldwu.main.controller;

import com.donaldwu.main.requestbody.CreateUserRequestBody;
import com.donaldwu.main.responsebody.MainResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api")
public class UserController {
    @RequestMapping(value="", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public static MainResponseBody createUser(@RequestBody CreateUserRequestBody createUserRequestBody) {
        String username = createUserRequestBody.getUsername();
        System.out.printf("username = %s", username);

        MainResponseBody mainResponseBody = new MainResponseBody();
        mainResponseBody.setMessage("create user");
        return mainResponseBody;
    }
}
