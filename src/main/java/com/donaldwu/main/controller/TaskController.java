package com.donaldwu.main.controller;

import com.donaldwu.main.entity.TaskEntity;
import com.donaldwu.main.requestbody.CreateTaskRequestBody;
import com.donaldwu.main.requestbody.UpdateTaskRequestBody;
import com.donaldwu.main.responsebody.*;
import com.donaldwu.main.service.TaskService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
@Log
public class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping(value="/task/create-task", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    private CreateTaskResponseBody createTask(@RequestBody CreateTaskRequestBody createTaskRequestBody, TaskEntity taskEntity) {
        String taskMessage = createTaskRequestBody.getTaskMessage();
        Long userId = createTaskRequestBody.getUser_id();
        if (taskMessage != null && !taskMessage.isEmpty() && userId != null) {
            taskService.createTask(taskEntity, taskMessage, userId);
        }

        CreateTaskResponseBody createTaskResponseBody = new CreateTaskResponseBody();
        createTaskResponseBody.setMessage("create task");
        return createTaskResponseBody;
    }

    @RequestMapping(value="/task", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    private GetAllTaskResponseBody getAllTask(@RequestParam(value = "user_id", required = false) String userIdRequestParam) {
        List<TaskEntity> taskList = taskService.getAllTask();

        if (userIdRequestParam != null) {
            List<TaskEntity> formattedTaskList = new ArrayList<>();
            for (TaskEntity taskEntity : taskList) {
                Long userIdFromDB = taskEntity.getUser_id();
                Long userIdLongRequestParam = Long.parseLong(userIdRequestParam, 10);
                if (userIdFromDB.equals(userIdLongRequestParam)) {
                    formattedTaskList.add(taskEntity);
                }
            }
            taskList = formattedTaskList;
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
        TaskEntity taskEntity = taskService.getTaskById(id);

        GetTaskByIdResponseBody getTaskByIdResponseBody = new GetTaskByIdResponseBody();
        getTaskByIdResponseBody.setMessage("get task by id");
        getTaskByIdResponseBody.setTask(taskEntity);

        return getTaskByIdResponseBody;
    }

    @RequestMapping(value="/task/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    private UpdateTaskResponseBody updateTaskById(@PathVariable(value = "id") long id, @RequestBody UpdateTaskRequestBody updateTaskRequestBody) {
        TaskEntity taskEntity = taskService.getTaskById(id);
        if (taskEntity != null) {
            String taskMessage = updateTaskRequestBody.getTaskMessage();
            Long userId = updateTaskRequestBody.getUser_id();
            taskService.updateTaskById(id, taskMessage, userId);
        }

        UpdateTaskResponseBody updateTaskResponseBody = new UpdateTaskResponseBody();
        updateTaskResponseBody.setMessage("update task by id");
        return updateTaskResponseBody;
    }

    @RequestMapping(value="/task/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    private DeleteTaskResponseBody deleteTaskById(@PathVariable(value = "id") long id) {
        TaskEntity taskEntity = taskService.getTaskById(id);
        if (taskEntity != null) {
            taskService.deleteTaskById(id);
        }

        DeleteTaskResponseBody deleteTaskResponseBody = new DeleteTaskResponseBody();
        deleteTaskResponseBody.setMessage("delete task by id");
        return deleteTaskResponseBody;
    }
}
