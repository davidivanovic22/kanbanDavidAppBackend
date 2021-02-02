create table task
(
    task_id            int auto_increment
        primary key,
    project_id         int          null,
    status_id          int          not null,
    name               varchar(128) not null,
    description        text         not null,
    due_date           date         not null,
    created_date       date         null,
    last_modified_by   varchar(128) null,
    last_modified_date date         null,
    record_status      int          null,
    constraint FK_RELATIONSHIP_5
        foreign key (status_id) references status (status_id),
    constraint FK_RELATIONSHIP_6
        foreign key (project_id) references project (project_id)
);

INSERT INTO kanban.task (task_id, project_id, status_id, name, description, due_date, created_date, last_modified_by, last_modified_date, record_status) VALUES (4, 1, 3, 'Pravi3', 'Neki3', '2021-01-29', null, null, null, 1);
INSERT INTO kanban.task (task_id, project_id, status_id, name, description, due_date, created_date, last_modified_by, last_modified_date, record_status) VALUES (7, 1, 2, 'Pravi6', 'Neki6', '2021-01-29', null, null, null, 1);
INSERT INTO kanban.task (task_id, project_id, status_id, name, description, due_date, created_date, last_modified_by, last_modified_date, record_status) VALUES (8, 1, 5, 'Pravi7', 'Neki7', '2021-01-28', null, null, null, 1);
INSERT INTO kanban.task (task_id, project_id, status_id, name, description, due_date, created_date, last_modified_by, last_modified_date, record_status) VALUES (9, 1, 2, 'Pravi8', 'Neki8', '2021-01-31', null, null, null, 1);
INSERT INTO kanban.task (task_id, project_id, status_id, name, description, due_date, created_date, last_modified_by, last_modified_date, record_status) VALUES (14, 1, 1, 'Zadatak uradi ovo', 'Uradi to
Uradi ovo
', '2021-01-30', null, null, null, 1);
INSERT INTO kanban.task (task_id, project_id, status_id, name, description, due_date, created_date, last_modified_by, last_modified_date, record_status) VALUES (20, 3, 2, 'Dodajem task', 'Uradicu task', '2021-02-28', null, null, null, 1);
INSERT INTO kanban.task (task_id, project_id, status_id, name, description, due_date, created_date, last_modified_by, last_modified_date, record_status) VALUES (21, 1, 1, 'Css za applikaciju', 'Odradi to
Odradi i ovo', '2021-01-31', null, null, null, 1);