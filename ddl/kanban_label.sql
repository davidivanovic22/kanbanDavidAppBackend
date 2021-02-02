create table label
(
    label_id           int auto_increment
        primary key,
    name               varchar(128)                          not null,
    background_color   varchar(64)                           null,
    text_color         varchar(64)                           null,
    record_status      int                                   null,
    created_date       date                                  null,
    last_modified_date timestamp default current_timestamp() not null on update current_timestamp(),
    last_modified_by   varchar(43)                           null
);

INSERT INTO kanban.label (label_id, name, background_color, text_color, record_status, created_date, last_modified_date, last_modified_by) VALUES (1, 'Frontend', '#4000ff', 'white', null, null, '2021-01-29 17:04:02', null);
INSERT INTO kanban.label (label_id, name, background_color, text_color, record_status, created_date, last_modified_date, last_modified_by) VALUES (2, 'Backend', '#0000ff', 'white', null, null, '2021-01-29 17:04:02', null);
INSERT INTO kanban.label (label_id, name, background_color, text_color, record_status, created_date, last_modified_date, last_modified_by) VALUES (3, 'Done', '#00ffff', 'white', null, null, '2021-01-29 17:04:02', null);
INSERT INTO kanban.label (label_id, name, background_color, text_color, record_status, created_date, last_modified_date, last_modified_by) VALUES (4, 'Approved', '#00ff40', 'white', null, null, '2021-01-29 17:04:02', null);
INSERT INTO kanban.label (label_id, name, background_color, text_color, record_status, created_date, last_modified_date, last_modified_by) VALUES (5, 'Documentation', '#f5f5f0', 'black', null, null, '2021-01-29 17:05:39', null);
INSERT INTO kanban.label (label_id, name, background_color, text_color, record_status, created_date, last_modified_date, last_modified_by) VALUES (6, 'Critical', '#ff00ff', 'white', null, null, '2021-01-29 17:04:02', null);
INSERT INTO kanban.label (label_id, name, background_color, text_color, record_status, created_date, last_modified_date, last_modified_by) VALUES (7, 'Database', '#ffbf00', 'white', null, null, '2021-01-29 17:04:02', null);
INSERT INTO kanban.label (label_id, name, background_color, text_color, record_status, created_date, last_modified_date, last_modified_by) VALUES (8, 'Deffered', '#8000ff', 'white', null, null, '2021-01-29 17:04:02', null);
INSERT INTO kanban.label (label_id, name, background_color, text_color, record_status, created_date, last_modified_date, last_modified_by) VALUES (9, 'Rejected', '#ff0000', 'white', null, null, '2021-01-29 17:04:02', null);