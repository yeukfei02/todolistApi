
create table todolist_user (
  user_id serial primary key,
  user_name varchar(255) not null,
  created_by timestamp not null default CURRENT_TIMESTAMP,
  updated_by timestamp not null default CURRENT_TIMESTAMP
);

create table task (
  task_id serial primary key,
  task_message text not null,
  user_id int not null references todolist_user (user_id),
  created_by timestamp not null default CURRENT_TIMESTAMP,
  updated_by timestamp not null default CURRENT_TIMESTAMP
);

--DROP TABLE task;
--DROP TABLE todolist_user;