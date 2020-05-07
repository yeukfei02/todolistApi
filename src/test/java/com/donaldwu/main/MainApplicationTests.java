package com.donaldwu.main;

import com.donaldwu.main.entity.TaskEntity;
import com.donaldwu.main.entity.UserEntity;
import com.donaldwu.main.repository.TaskRepository;
import com.donaldwu.main.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@SpringBootTest
class MainApplicationTests {
	private static final Logger logger = Logger.getLogger(MainApplicationTests.class.toString());

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TaskRepository taskRepository;

	@Test
	public void test_001_createUser() {
		logger.info("test_001_createUser start");

		UserEntity userEntity = new UserEntity();
		userEntity.setUsername("test123123");
		userRepository.save(userEntity);

		List<UserEntity> userEntities = userRepository.findAll();
		UserEntity lastUser = userEntities.get(userEntities.size() - 1);
		if (lastUser != null) {
			Long userId = lastUser.getUser_id();
			String username = lastUser.getUsername();
			Assert.assertNotNull("userId should not be null", userId);
			Assert.assertNotNull("username should not be null", username);
			Assert.assertEquals("test123123", username);
		}
	}

	@Test
	public void test_002_getAllUser() {
		logger.info("test_002_getAllUser start");

		List<UserEntity> userEntities = userRepository.findAll();
		if (!userEntities.isEmpty()) {
			for (UserEntity	userEntity : userEntities) {
				Long userId = userEntity.getUser_id();
				String username = userEntity.getUsername();
				Assert.assertNotNull("userId should not be null", userId);
				Assert.assertNotNull("username should not be null", username);
			}
		}
	}

	@Test
	public void test_003_createTask() {
		logger.info("test_003_createTask start");

		TaskEntity taskEntity = new TaskEntity();
		taskEntity.setTaskMessage("taskMessage123");
		taskEntity.setUserId(1L);
		taskRepository.save(taskEntity);

		List<TaskEntity> taskEntities = taskRepository.findAll();
		TaskEntity lastTask = taskEntities.get(taskEntities.size() - 1);
		if (lastTask != null) {
			Long taskId = taskEntity.getTask_id();
			String taskMessage = taskEntity.getTaskMessage();
			Long userId = taskEntity.getUserId();
			Assert.assertNotNull("taskId should not be null", taskId);
			Assert.assertNotNull("taskMessage should not be null", taskMessage);
			Assert.assertNotNull("userId should not be null", userId);
			Assert.assertEquals("taskMessage123", taskMessage);
			Assert.assertEquals(1L, (long) userId);
		}
	}

	@Test
	public void test_004_getAllTask() {
		logger.info("test_004_getAllTask start");

		List<TaskEntity> taskEntities = taskRepository.findAll();
		if (!taskEntities.isEmpty()) {
			for (TaskEntity	taskEntity : taskEntities) {
				Long taskId = taskEntity.getTask_id();
				String taskMessage = taskEntity.getTaskMessage();
				Long userId = taskEntity.getUserId();
				Assert.assertNotNull("taskId should not be null", taskId);
				Assert.assertNotNull("taskMessage should not be null", taskMessage);
				Assert.assertNotNull("userId should not be null", userId);
			}
		}
	}

	@Test
	void test_005_getTaskById() {
		logger.info("test_005_getTaskById start");

		Optional<TaskEntity> taskEntityOptional = taskRepository.findById(1L);
		if (taskEntityOptional.isPresent()) {
			TaskEntity taskEntity = taskEntityOptional.get();
			Long taskId = taskEntity.getTask_id();
			String taskMessage = taskEntity.getTaskMessage();
			Long userId = taskEntity.getUserId();
			Assert.assertNotNull("taskId should not be null", taskId);
			Assert.assertNotNull("taskMessage should not be null", taskMessage);
			Assert.assertNotNull("userId should not be null", userId);
		}
	}

	@Test
	public void test_006_updateTaskById() {
		logger.info("test_006_updateTaskById start");

		Optional<TaskEntity> taskEntityOptional = taskRepository.findById(1L);
		if (taskEntityOptional.isPresent()) {
			TaskEntity taskEntity = taskEntityOptional.get();
			taskEntity.setTaskMessage("taskMessage567");
			taskEntity.setUserId(2L);
			taskRepository.save(taskEntity);

			Long taskId = taskEntity.getTask_id();
			String taskMessage = taskEntity.getTaskMessage();
			Long userId = taskEntity.getUserId();
			Assert.assertNotNull("taskId should not be null", taskId);
			Assert.assertNotNull("taskMessage should not be null", taskMessage);
			Assert.assertNotNull("userId should not be null", userId);
			Assert.assertEquals("taskMessage567", taskMessage);
			Assert.assertEquals(2L, (long) userId);
		}
	}
}
