create table role
(
    role_id            int auto_increment
        primary key,
    name               varchar(128)                          not null,
    created_date       date                                  null,
    last_modified_date timestamp default current_timestamp() not null on update current_timestamp(),
    last_modified_by   varchar(43)                           null,
    record_status      int                                   null
);

INSERT INTO kanban.role (role_id, name, created_date, last_modified_date, last_modified_by, record_status) VALUES (1, 'ADMIN', null, '2021-01-26 22:08:05', null, null);
INSERT INTO kanban.role (role_id, name, created_date, last_modified_date, last_modified_by, record_status) VALUES (2, 'DEVELOPER', null, '2021-01-27 02:23:54', null, null);