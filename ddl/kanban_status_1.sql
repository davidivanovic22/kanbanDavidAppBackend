create table status
(
    status_id          int auto_increment
        primary key,
    name               varchar(128)                          not null,
    last_modified_date timestamp default current_timestamp() not null on update current_timestamp(),
    last_modified_by   varchar(43)                           null,
    record_status      int                                   null,
    created_date       date                                  null
);

INSERT INTO kanban.status (status_id, name, last_modified_date, last_modified_by, record_status, created_date) VALUES (1, 'TESTING', '2021-01-26 22:05:35', null, null, null);
INSERT INTO kanban.status (status_id, name, last_modified_date, last_modified_by, record_status, created_date) VALUES (2, 'BACKLOG', '2021-01-26 22:05:35', null, null, null);
INSERT INTO kanban.status (status_id, name, last_modified_date, last_modified_by, record_status, created_date) VALUES (3, 'IN PROGRESS', '2021-01-26 22:05:35', null, null, null);
INSERT INTO kanban.status (status_id, name, last_modified_date, last_modified_by, record_status, created_date) VALUES (4, 'TO DO', '2021-01-26 22:06:06', null, null, null);
INSERT INTO kanban.status (status_id, name, last_modified_date, last_modified_by, record_status, created_date) VALUES (5, 'DONE', '2021-01-26 22:06:06', null, null, null);
INSERT INTO kanban.status (status_id, name, last_modified_date, last_modified_by, record_status, created_date) VALUES (6, 'REVIEW', '2021-01-26 22:06:06', null, null, null);