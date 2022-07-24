CREATE INDEX index_users_on_user_name ON users(user_name);
CREATE INDEX index_users_on_created_at ON users(created_at);
CREATE INDEX index_users_on_updated_at ON users(updated_at);

CREATE INDEX index_tasks_on_task_message ON tasks(task_message);
CREATE INDEX index_tasks_on_user_id ON tasks(user_id);
CREATE INDEX index_tasks_on_created_at ON tasks(created_at);
CREATE INDEX index_tasks_on_updated_at ON tasks(updated_at);