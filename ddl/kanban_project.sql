create table project
(
    project_id         int auto_increment
        primary key,
    name               varchar(128)                          not null,
    description        text                                  not null,
    start_date         date                                  not null,
    end_date           date                                  not null,
    created_date       date                                  null,
    last_modified_date timestamp default current_timestamp() not null on update current_timestamp(),
    last_modified_by   varchar(43)                           null,
    record_status      int                                   null
);

INSERT INTO kanban.project (project_id, name, description, start_date, end_date, created_date, last_modified_date, last_modified_by, record_status) VALUES (1, 'KANBAN board', 'Neki', '2021-01-23', '2021-01-31', null, '2021-01-30 05:05:07', null, null);
INSERT INTO kanban.project (project_id, name, description, start_date, end_date, created_date, last_modified_date, last_modified_by, record_status) VALUES (2, 'Jos jedan', 'Jos jedan', '2021-01-26', '2021-01-31', null, '2021-01-26 23:17:40', null, null);
INSERT INTO kanban.project (project_id, name, description, start_date, end_date, created_date, last_modified_date, last_modified_by, record_status) VALUES (3, 'IT255', 'Angular', '2021-01-31', '2021-02-28', null, '2021-01-31 01:15:31', null, 1);