package com.donaldwu.main.controller;

import com.donaldwu.main.requestbody.CreateTaskRequestBody;
import com.donaldwu.main.responsebody.GetAllTaskResponseBody;
import com.donaldwu.main.responsebody.GetTaskByIdResponseBody;
import com.donaldwu.main.responsebody.MainResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TaskController {
    @RequestMapping(value="/task/create-task", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public static MainResponseBody createTask(@RequestBody CreateTaskRequestBody createTaskRequestBody) {
        String taskTitle = createTaskRequestBody.getTaskTitle();
        String taskDescription = createTaskRequestBody.getTaskDescription();
        System.out.printf("taskTitle = %s, taskDescription = %s", taskTitle, taskDescription);

        MainResponseBody mainResponseBody = new MainResponseBody();
        mainResponseBody.setMessage("create task");
        return mainResponseBody;
    }

    @RequestMapping(value="/task", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static GetAllTaskResponseBody getAllTask() {
        GetAllTaskResponseBody getAllTaskResponseBody = new GetAllTaskResponseBody();
        getAllTaskResponseBody.setMessage("get all task");

        List<Object> tasks = new ArrayList<>();
        Map<String, String> testMap = new HashMap<>();
        testMap.put("test", "test");
        tasks.add(testMap);
        Map<String, String> testMap2 = new HashMap<>();
        testMap2.put("test2", "test2");
        tasks.add(testMap2);
        getAllTaskResponseBody.setTasks(tasks);
        return getAllTaskResponseBody;
    }

    @RequestMapping(value="/task/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static GetTaskByIdResponseBody getTaskById(@PathVariable(value = "id") int id) {
        System.out.printf("id = %d", id);

        GetTaskByIdResponseBody getTaskByIdResponseBody = new GetTaskByIdResponseBody();
        getTaskByIdResponseBody.setMessage("get task by id");

        Map<String, String> testMap = new HashMap<>();
        testMap.put("test", "test");
        getTaskByIdResponseBody.setTask(testMap);
        return getTaskByIdResponseBody;
    }

    @RequestMapping(value="/task/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static MainResponseBody updateTaskById(@PathVariable(value = "id") int id) {
        System.out.printf("id = %d", id);

        MainResponseBody mainResponseBody = new MainResponseBody();
        mainResponseBody.setMessage("update task by id");
        return mainResponseBody;
    }

    @RequestMapping(value="/task/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public static MainResponseBody deleteTaskById(@PathVariable(value = "id") int id) {
        System.out.printf("id = %d", id);

        MainResponseBody mainResponseBody = new MainResponseBody();
        mainResponseBody.setMessage("delete task by id");
        return mainResponseBody;
    }
}
