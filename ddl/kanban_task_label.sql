create table task_label
(
    label_id int not null,
    task_id  int not null,
    primary key (label_id, task_id),
    constraint FK_RELATIONSHIP_10
        foreign key (label_id) references label (label_id),
    constraint FK_RELATIONSHIP_11
        foreign key (task_id) references task (task_id)
);

INSERT INTO kanban.task_label (label_id, task_id) VALUES (1, 8);
INSERT INTO kanban.task_label (label_id, task_id) VALUES (1, 14);
INSERT INTO kanban.task_label (label_id, task_id) VALUES (1, 20);
INSERT INTO kanban.task_label (label_id, task_id) VALUES (1, 21);
INSERT INTO kanban.task_label (label_id, task_id) VALUES (2, 4);
INSERT INTO kanban.task_label (label_id, task_id) VALUES (2, 7);
INSERT INTO kanban.task_label (label_id, task_id) VALUES (2, 14);
INSERT INTO kanban.task_label (label_id, task_id) VALUES (2, 20);
INSERT INTO kanban.task_label (label_id, task_id) VALUES (5, 9);
INSERT INTO kanban.task_label (label_id, task_id) VALUES (6, 9);
INSERT INTO kanban.task_label (label_id, task_id) VALUES (6, 14);
INSERT INTO kanban.task_label (label_id, task_id) VALUES (6, 21);