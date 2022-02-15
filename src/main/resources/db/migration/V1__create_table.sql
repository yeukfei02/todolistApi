create table users (
  user_id serial primary key,
  user_name varchar(255) not null,
  created_at timestamp not null default CURRENT_TIMESTAMP,
  updated_at timestamp not null default CURRENT_TIMESTAMP
);

create table tasks (
  task_id serial primary key,
  task_message text not null,
  user_id int not null references users (user_id),
  created_at timestamp not null default CURRENT_TIMESTAMP,
  updated_at timestamp not null default CURRENT_TIMESTAMP
);
