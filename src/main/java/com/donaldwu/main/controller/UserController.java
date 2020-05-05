package com.donaldwu.main.controller;

import com.donaldwu.main.entity.UserEntity;
import com.donaldwu.main.requestbody.CreateUserRequestBody;
import com.donaldwu.main.responsebody.GetAllUserResponseBody;
import com.donaldwu.main.responsebody.MainResponseBody;
import com.donaldwu.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @RequestMapping(value="/user", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    private GetAllUserResponseBody getAllUser() {
        List<Object> userList = new ArrayList<>();

        List<UserEntity> userEntities = userService.getAllUser();
        if (!userEntities.isEmpty()) {
            for (UserEntity userEntity : userEntities) {
                Map<String, Object> testMap = new HashMap<>();

                Long userId = userEntity.getUser_id();
                String username = userEntity.getUsername();
                testMap.put("userId", userId);
                testMap.put("username", username);

                userList.add(testMap);
            }
        }

        GetAllUserResponseBody getAllUserResponseBody = new GetAllUserResponseBody();
        getAllUserResponseBody.setMessage("get all user");
        getAllUserResponseBody.setUsers(userList);
        return getAllUserResponseBody;
    }
}
