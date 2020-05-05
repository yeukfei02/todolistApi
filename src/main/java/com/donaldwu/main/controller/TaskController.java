package com.donaldwu.main.controller;

import com.donaldwu.main.entity.TaskEntity;
import com.donaldwu.main.requestbody.CreateTaskRequestBody;
import com.donaldwu.main.requestbody.UpdateTaskRequestBody;
import com.donaldwu.main.responsebody.GetAllTaskResponseBody;
import com.donaldwu.main.responsebody.GetTaskByIdResponseBody;
import com.donaldwu.main.responsebody.MainResponseBody;
import com.donaldwu.main.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class TaskController {
    private static final Logger logger = Logger.getLogger(TaskController.class.toString());

    @Autowired
    private TaskService taskService;

    @RequestMapping(value="/task/create-task", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    private MainResponseBody createTask(@RequestBody CreateTaskRequestBody createTaskRequestBody, TaskEntity taskEntity) {
        String taskMessage = createTaskRequestBody.getTaskMessage();
        Long userId = createTaskRequestBody.getUserId();
        if (taskMessage != null && !taskMessage.isEmpty() && userId != null) {
            taskService.createTask(taskEntity, taskMessage, userId);
        }

        MainResponseBody mainResponseBody = new MainResponseBody();
        mainResponseBody.setMessage("create task");
        return mainResponseBody;
    }

    @RequestMapping(value="/task", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    private GetAllTaskResponseBody getAllTask() {
        GetAllTaskResponseBody getAllTaskResponseBody = new GetAllTaskResponseBody();
        getAllTaskResponseBody.setMessage("get all task");

        List<TaskEntity> taskEntities = taskService.getAllTask();
        logger.info("taskEntities = " + taskEntities);

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
    private GetTaskByIdResponseBody getTaskById(@PathVariable(value = "id") long id) {
        if (id > 0) {
            Optional<TaskEntity> task = taskService.getTaskById(id);
            logger.info("task = " + task);
        }

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
    private MainResponseBody updateTaskById(@PathVariable(value = "id") long id, @RequestBody UpdateTaskRequestBody updateTaskRequestBody) {
        if (id > 0) {
            String taskMessage = updateTaskRequestBody.getTaskMessage();
            Long userId = updateTaskRequestBody.getUserId();
            taskService.updateTaskById(id, taskMessage, userId);
        }

        MainResponseBody mainResponseBody = new MainResponseBody();
        mainResponseBody.setMessage("update task by id");
        return mainResponseBody;
    }

    @RequestMapping(value="/task/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    private MainResponseBody deleteTaskById(@PathVariable(value = "id") long id) {
        if (id > 0) {
            taskService.deleteTaskById(id);
        }

        MainResponseBody mainResponseBody = new MainResponseBody();
        mainResponseBody.setMessage("delete task by id");
        return mainResponseBody;
    }
}
