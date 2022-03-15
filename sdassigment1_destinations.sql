create table destinations
(
    ID   int auto_increment,
    name varchar(255) null,
    constraint destinations_ID_uindex
        unique (ID)
);

create index ID
    on destinations (ID);

INSERT INTO sdassigment1.destinations (ID, name) VALUES (1, 'Madrid');
INSERT INTO sdassigment1.destinations (ID, name) VALUES (2, 'Bucovina');
INSERT INTO sdassigment1.destinations (ID, name) VALUES (3, 'Paris');
INSERT INTO sdassigment1.destinations (ID, name) VALUES (4, 'Ireland');
INSERT INTO sdassigment1.destinations (ID, name) VALUES (5, 'California');
INSERT INTO sdassigment1.destinations (ID, name) VALUES (9, 'Test');