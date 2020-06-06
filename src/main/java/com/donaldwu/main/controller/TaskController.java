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
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
    private GetAllTaskResponseBody getAllTask(@RequestParam(value = "userId", required = false) String userIdRequestParam) {
        List<Map<String, Object>> taskList = new ArrayList<>();

        List<TaskEntity> taskEntities = taskService.getAllTask();
        if (userIdRequestParam == null) {
            if (taskEntities != null && !taskEntities.isEmpty()) {
                for (TaskEntity taskEntity : taskEntities) {
                    Map<String, Object> testMap = new HashMap<>();

                    Long taskId = taskEntity.getTask_id();
                    String taskMessage = taskEntity.getTaskMessage();
                    Long userId = taskEntity.getUserId();
                    testMap.put("taskId", taskId);
                    testMap.put("taskMessage", taskMessage);
                    testMap.put("userId", userId);

                    taskList.add(testMap);
                }
            }
        } else {
            if (taskEntities != null && !taskEntities.isEmpty()) {
                for (TaskEntity taskEntity : taskEntities) {
                    Long userIdFromDB = taskEntity.getUserId();
                    Long userIdLongRequestParam = Long.parseLong(userIdRequestParam, 10);
                    if (userIdFromDB.equals(userIdLongRequestParam)) {
                        Map<String, Object> testMap = new HashMap<>();

                        Long taskId = taskEntity.getTask_id();
                        String taskMessage = taskEntity.getTaskMessage();
                        Long userId = taskEntity.getUserId();
                        testMap.put("taskId", taskId);
                        testMap.put("taskMessage", taskMessage);
                        testMap.put("userId", userId);

                        taskList.add(testMap);
                    }
                }
            }
        }

        GetAllTaskResponseBody getAllTaskResponseBody = new GetAllTaskResponseBody();
        getAllTaskResponseBody.setMessage("get all task");
        getAllTaskResponseBody.setTasks(taskList);
        return getAllTaskResponseBody;
    }

    @RequestMapping(value="/task/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    private GetTaskByIdResponseBody getTaskById(@PathVariable(value = "id") long id) {
        GetTaskByIdResponseBody getTaskByIdResponseBody = new GetTaskByIdResponseBody();
        getTaskByIdResponseBody.setMessage("get task by id");

        TaskEntity taskEntity = taskService.getTaskById(id);
        if (taskEntity != null) {
            Map<String, Object> testMap = new HashMap<>();

            Long taskId = taskEntity.getTask_id();
            String taskMessage = taskEntity.getTaskMessage();
            Long userId = taskEntity.getUserId();
            testMap.put("taskId", taskId);
            testMap.put("taskMessage", taskMessage);
            testMap.put("userId", userId);

            getTaskByIdResponseBody.setTask(testMap);
        }
        return getTaskByIdResponseBody;
    }

    @RequestMapping(value="/task/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    private MainResponseBody updateTaskById(@PathVariable(value = "id") long id, @RequestBody UpdateTaskRequestBody updateTaskRequestBody) {
        TaskEntity taskEntity = taskService.getTaskById(id);
        if (taskEntity != null) {
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
        TaskEntity taskEntity = taskService.getTaskById(id);
        if (taskEntity != null) {
            taskService.deleteTaskById(id);
        }

        MainResponseBody mainResponseBody = new MainResponseBody();
        mainResponseBody.setMessage("delete task by id");
        return mainResponseBody;
    }
}
