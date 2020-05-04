package com.donaldwu.main;

import com.donaldwu.main.routes.MainRoute;
import com.donaldwu.main.routes.TaskRoute;
import com.donaldwu.main.routes.UserRoute;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);

		// main route
		MainRoute.getMain();

		// user route
		UserRoute.createUser();

		// task route
		TaskRoute.createTask();
		TaskRoute.getAllTask();
		TaskRoute.getTaskById();
		TaskRoute.updateTaskById();
		TaskRoute.deleteTaskById();
	}
}
