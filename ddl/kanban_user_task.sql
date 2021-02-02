create table user_task
(
    user_id int not null,
    task_id int not null,
    primary key (task_id, user_id),
    constraint user_task_task_task_id_fk
        foreign key (task_id) references task (task_id),
    constraint user_task_user_user_id_fk
        foreign key (user_id) references user (user_id)
);

INSERT INTO kanban.user_task (user_id, task_id) VALUES (3, 4);
INSERT INTO kanban.user_task (user_id, task_id) VALUES (7, 7);
INSERT INTO kanban.user_task (user_id, task_id) VALUES (2, 8);
INSERT INTO kanban.user_task (user_id, task_id) VALUES (1, 9);
INSERT INTO kanban.user_task (user_id, task_id) VALUES (1, 14);
INSERT INTO kanban.user_task (user_id, task_id) VALUES (3, 14);
INSERT INTO kanban.user_task (user_id, task_id) VALUES (5, 20);
INSERT INTO kanban.user_task (user_id, task_id) VALUES (6, 20);
INSERT INTO kanban.user_task (user_id, task_id) VALUES (1, 21);
INSERT INTO kanban.user_task (user_id, task_id) VALUES (2, 21);