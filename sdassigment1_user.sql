create table user
(
    id    int auto_increment,
    name  varchar(255) null,
    hash  varchar(255) null,
    type  int          null,
    email varchar(255) null,
    constraint user_email_uindex
        unique (email),
    constraint user_id_uindex
        unique (id),
    constraint user_name_uindex
        unique (name)
);

create index id
    on user (id);

INSERT INTO sdassigment1.user (id, name, hash, type, email) VALUES (1, 'uhu', 'B97C72702F44C66C2DE2ECDFE321705F', 0, 'huu@gmail.com');
INSERT INTO sdassigment1.user (id, name, hash, type, email) VALUES (2, 'testingg', '6BC432B68AA99743E57BF6C7E0B773BD', 0, 'test@gmail.com');
INSERT INTO sdassigment1.user (id, name, hash, type, email) VALUES (3, 'test', '49A5A960C5714C2E29DD1A7E7B950741', 0, 'testtttt@gmail.com');
INSERT INTO sdassigment1.user (id, name, hash, type, email) VALUES (6, 'hehe', 'A5037C5C90E0E261E769CC12D4013162', 0, 'asd@gmail.com');
INSERT INTO sdassigment1.user (id, name, hash, type, email) VALUES (7, 'razvan', '49A5A960C5714C2E29DD1A7E7B950741', 1, 'razvandumm@gmail.com');
INSERT INTO sdassigment1.user (id, name, hash, type, email) VALUES (8, 'ratza', 'B97C72702F44C66C2DE2ECDFE321705F', 0, 'ratza@gmail.com');
INSERT INTO sdassigment1.user (id, name, hash, type, email) VALUES (13, 'hello', '49A5A960C5714C2E29DD1A7E7B950741', 0, 'hello@gmail.com');