create table user_role
(
    user_id int not null,
    role_id int not null,
    primary key (user_id, role_id),
    constraint FK_RELATIONSHIP_1
        foreign key (user_id) references user (user_id),
    constraint FK_RELATIONSHIP_2
        foreign key (role_id) references role (role_id)
);

INSERT INTO kanban.user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO kanban.user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO kanban.user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO kanban.user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO kanban.user_role (user_id, role_id) VALUES (5, 2);
INSERT INTO kanban.user_role (user_id, role_id) VALUES (6, 2);
INSERT INTO kanban.user_role (user_id, role_id) VALUES (7, 2);