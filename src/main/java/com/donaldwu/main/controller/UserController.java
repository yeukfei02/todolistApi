package com.donaldwu.main.controller;

import com.donaldwu.main.model.User;
import com.donaldwu.main.dto.CreateUserDto;
import com.donaldwu.main.responsebody.CreateUserResponseBody;
import com.donaldwu.main.responsebody.GetAllUserResponseBody;
import com.donaldwu.main.responsebody.GetUserIdResponseBody;
import com.donaldwu.main.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/api")
@Log
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/user/create-user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    private CreateUserResponseBody createUser(@RequestBody CreateUserDto createUserDto, User user) {
        String username = createUserDto.getUsername();
        if (username != null && !username.isEmpty()) {
            userService.createUser(user, username);
        }

        User lastUser = userService.getLastUser();
        Long userId = lastUser.getUser_id();

        CreateUserResponseBody createUserResponseBody = new CreateUserResponseBody();
        createUserResponseBody.setMessage("create user");
        createUserResponseBody.setUser_id(userId);
        return createUserResponseBody;
    }

    @RequestMapping(value="/user", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    private GetAllUserResponseBody getAllUser() {
        List<User> userList = new ArrayList<>();

        Iterable<User> userEntities = userService.getAllUser();
        userEntities.forEach(userList::add);

        GetAllUserResponseBody getAllUserResponseBody = new GetAllUserResponseBody();
        getAllUserResponseBody.setMessage("get all user");
        getAllUserResponseBody.setUsers(userList);
        return getAllUserResponseBody;
    }

    @RequestMapping(value="/user/get-user-id", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    private GetUserIdResponseBody getUserId(@RequestParam(value = "username") String username) {
        User user = userService.getUserByUsername(username);
        Long userId = user.getUser_id();

        GetUserIdResponseBody getUserIdResponseBody = new GetUserIdResponseBody();
        getUserIdResponseBody.setMessage("get user id");
        getUserIdResponseBody.setUser_id(userId);
        return getUserIdResponseBody;
    }
}
