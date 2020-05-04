
create table user (
  userId serial primary key,
  userName varchar(255) not null,
  createdBy timestamp not null default CURRENT_TIMESTAMP,
  updatedBy timestamp not null default CURRENT_TIMESTAMP
);

create table task (
  taskId serial primary key,
  taskTitle varchar(255) not null,
  taskDescription varchar(255) not null,
  userId int not null references user (userId),
  createdBy timestamp not null default CURRENT_TIMESTAMP,
  updatedBy timestamp not null default CURRENT_TIMESTAMP
);

--DROP TABLE task;
--DROP TABLE user;