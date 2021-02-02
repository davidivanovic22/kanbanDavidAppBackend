create table user
(
    user_id            int auto_increment
        primary key,
    first_name         varchar(128)                          not null,
    last_name          varchar(128)                          not null,
    prof_PIC           longblob                              null,
    email              varchar(128)                          not null,
    username           varchar(128)                          not null,
    password           varchar(128)                          null,
    last_modified_date timestamp default current_timestamp() not null on update current_timestamp(),
    last_modified_by   varchar(43)                           null,
    record_status      int       default 1                   null,
    created_date       date                                  null
);

INSERT INTO kanban.user (user_id, first_name, last_name, prof_PIC, email, username, password, last_modified_date, last_modified_by, record_status, created_date) VALUES (1, 'admin', 'admin', 0x68747470733A2F2F63646E2E74686564657369676E696E737069726174696F6E2E636F6D2F77702D636F6E74656E742F75706C6F6164732F323031342F30312F466C61742D44657369676E2D4865726F65732D3030372E6A7067, 'admin', 'admin', '$2a$10$7dcB.VPAfS30rRWLQtHwM.cIVPMstkQnyet6zs9TNktiAPQtHv7AC', '2021-01-31 19:21:46', null, 1, null);
INSERT INTO kanban.user (user_id, first_name, last_name, prof_PIC, email, username, password, last_modified_date, last_modified_by, record_status, created_date) VALUES (2, 'David', 'Ivanović', 0x68747470733A2F2F692E70696E696D672E636F6D2F6F726967696E616C732F35362F63662F64662F35366366646663633362633931663266326561376465383839356535373730362E706E67, 'david@gmail.com', 'david', '$2a$10$ccFOJEtwDobUrj94cUAAGOr2Wz.JMLFGF.IRXqgQDpg/po7c2rqt.', '2021-01-31 19:18:38', null, 1, null);
INSERT INTO kanban.user (user_id, first_name, last_name, prof_PIC, email, username, password, last_modified_date, last_modified_by, record_status, created_date) VALUES (3, 'Djole', 'Djokić', 0x68747470733A2F2F63646E342E69636F6E66696E6465722E636F6D2F646174612F69636F6E732F617661746172732D786D61732D67697665617761792F3132382F6261746D616E5F6865726F5F6176617461725F636F6D6963732D3531322E706E67, 'djole@gmail.com', 'djole', '$2a$10$1TaUT20NBJx6Mf6OrSE42eA00mS165Q/qkOniSsI8LiZYTcPxu/.a', '2021-01-30 15:54:42', null, 1, null);
INSERT INTO kanban.user (user_id, first_name, last_name, prof_PIC, email, username, password, last_modified_date, last_modified_by, record_status, created_date) VALUES (5, 'Isak', 'Šabanović', 0x68747470733A2F2F706E672E706E676974656D2E636F6D2F70696D67732F732F3334362D333436383337355F7370696465726D616E2D6D63752D7073342D73656C6669652D68642D706E672D646F776E6C6F61642E706E67, 'isaks@gmail.com', 'isaksabanovic', null, '2021-01-30 17:49:33', null, 1, null);
INSERT INTO kanban.user (user_id, first_name, last_name, prof_PIC, email, username, password, last_modified_date, last_modified_by, record_status, created_date) VALUES (6, 'Marko', 'Markovic', 0x68747470733A2F2F75706C6F6164732D73736C2E776562666C6F772E636F6D2F3562653335393961616231633236316666323762376139332F3562666334666131353035373363343666303530666565635F30663630346664313339643939323435306237633032326131323737353539392E706E67, 'marko@gmail.com', 'marko', null, '2021-01-31 04:07:42', null, 1, null);
INSERT INTO kanban.user (user_id, first_name, last_name, prof_PIC, email, username, password, last_modified_date, last_modified_by, record_status, created_date) VALUES (7, 'Mario', 'Ferketic', 0x68747470733A2F2F6D69722D73332D63646E2D63662E626568616E63652E6E65742F70726F6A6563745F6D6F64756C65732F313430302F64623738303133383635303530352E353938666131313935363736312E6A7067, 'mario@gmail.com', 'maki', null, '2021-01-31 21:14:17', null, 1, null);