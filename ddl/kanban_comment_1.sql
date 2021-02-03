create table comment
(
    comment_id         int auto_increment
        primary key,
    task_id            int         not null,
    user_id            int         not null,
    comment_text       text        not null,
    last_modified_date date        null,
    last_modified_by   varchar(43) null,
    record_status      int         null,
    created_date       date        null,
    constraint FK_RELATIONSHIP_12
        foreign key (task_id) references task (task_id),
    constraint user_id
        foreign key (user_id) references user (user_id)
);

INSERT INTO kanban.comment (comment_id, task_id, user_id, comment_text, last_modified_date, last_modified_by, record_status, created_date) VALUES (21, 9, 1, 'Komentar za task Pravi 8                                                 
Komentar za task Pravi 8
Komentar za task Pravi 8
Komentar za task Pravi 8
Komentar za task Pravi 8
Komentar za task Pravi 8
Komentar za task Pravi 8', null, null, 1, null);
INSERT INTO kanban.comment (comment_id, task_id, user_id, comment_text, last_modified_date, last_modified_by, record_status, created_date) VALUES (22, 9, 2, 'Komentar za task Pravi 8', null, null, 1, null);
INSERT INTO kanban.comment (comment_id, task_id, user_id, comment_text, last_modified_date, last_modified_by, record_status, created_date) VALUES (23, 9, 3, 'Komentar za task Pravi 8', null, null, null, null);
INSERT INTO kanban.comment (comment_id, task_id, user_id, comment_text, last_modified_date, last_modified_by, record_status, created_date) VALUES (24, 9, 1, 'David Ivanovic', null, null, 1, null);
INSERT INTO kanban.comment (comment_id, task_id, user_id, comment_text, last_modified_date, last_modified_by, record_status, created_date) VALUES (25, 9, 1, 'Komentar za task Pravi 8', null, null, null, null);
INSERT INTO kanban.comment (comment_id, task_id, user_id, comment_text, last_modified_date, last_modified_by, record_status, created_date) VALUES (26, 9, 5, 'Komentar za task Pravi 8                                                 
Komentar za task Pravi 8
Komentar za task Pravi 8
Komentar za task Pravi 8
Komentar za task Pravi 8
Komentar za task Pravi 8
Komentar za task Pravi 8', null, null, null, null);
INSERT INTO kanban.comment (comment_id, task_id, user_id, comment_text, last_modified_date, last_modified_by, record_status, created_date) VALUES (28, 9, 1, 'Davdi ivanovic komentar', null, null, 1, null);
INSERT INTO kanban.comment (comment_id, task_id, user_id, comment_text, last_modified_date, last_modified_by, record_status, created_date) VALUES (29, 14, 1, 'Da li je zavrseno', null, null, 1, null);
INSERT INTO kanban.comment (comment_id, task_id, user_id, comment_text, last_modified_date, last_modified_by, record_status, created_date) VALUES (30, 21, 1, 'Css je bas dobar', null, null, 1, null);