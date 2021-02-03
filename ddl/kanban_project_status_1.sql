create table project_status
(
    status_id  int not null,
    project_id int not null,
    primary key (status_id, project_id),
    constraint FK_RELATIONSHIP_3
        foreign key (status_id) references status (status_id),
    constraint FK_RELATIONSHIP_4
        foreign key (project_id) references project (project_id)
);

INSERT INTO kanban.project_status (status_id, project_id) VALUES (1, 1);
INSERT INTO kanban.project_status (status_id, project_id) VALUES (1, 4);
INSERT INTO kanban.project_status (status_id, project_id) VALUES (2, 1);
INSERT INTO kanban.project_status (status_id, project_id) VALUES (2, 3);
INSERT INTO kanban.project_status (status_id, project_id) VALUES (3, 1);
INSERT INTO kanban.project_status (status_id, project_id) VALUES (3, 3);
INSERT INTO kanban.project_status (status_id, project_id) VALUES (4, 1);
INSERT INTO kanban.project_status (status_id, project_id) VALUES (5, 1);