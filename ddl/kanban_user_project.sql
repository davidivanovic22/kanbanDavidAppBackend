create table user_project
(
    user_id    int not null,
    project_id int not null,
    primary key (user_id, project_id),
    constraint FK_RELATIONSHIP_8
        foreign key (user_id) references user (user_id),
    constraint FK_RELATIONSHIP_9
        foreign key (project_id) references project (project_id)
);

INSERT INTO kanban.user_project (user_id, project_id) VALUES (1, 1);
INSERT INTO kanban.user_project (user_id, project_id) VALUES (1, 2);
INSERT INTO kanban.user_project (user_id, project_id) VALUES (1, 3);
INSERT INTO kanban.user_project (user_id, project_id) VALUES (2, 1);
INSERT INTO kanban.user_project (user_id, project_id) VALUES (2, 2);
INSERT INTO kanban.user_project (user_id, project_id) VALUES (3, 1);
INSERT INTO kanban.user_project (user_id, project_id) VALUES (5, 3);
INSERT INTO kanban.user_project (user_id, project_id) VALUES (6, 3);
INSERT INTO kanban.user_project (user_id, project_id) VALUES (7, 1);