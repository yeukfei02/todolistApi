package com.donaldwu.main.routes;

import com.donaldwu.main.controller.TaskController;
import com.donaldwu.main.requestbody.CreateTaskRequestBody;

public class TaskRoute {
    public static void createTask() {
        CreateTaskRequestBody createTaskRequestBody = new CreateTaskRequestBody();
        createTaskRequestBody.setTaskTitle("test");
        createTaskRequestBody.setTaskDescription("test123");
        TaskController.createTask(createTaskRequestBody);
    }

    public static void getAllTask() {
        TaskController.getAllTask();
    }

    public static void getTaskById() {
        TaskController.getTaskById(1);
    }

    public static void updateTaskById() {
        TaskController.updateTaskById(1);
    }

    public static void deleteTaskById() {
        TaskController.deleteTaskById(1);
    }
}
