create table userpackages
(
    UserID    int null,
    PackageID int null,
    constraint userpackages_user_id_fk
        foreign key (UserID) references user (id),
    constraint userpackages_vacationpackage_ID_fk
        foreign key (PackageID) references vacationpackage (ID)
);

INSERT INTO sdassigment1.userpackages (UserID, PackageID) VALUES (8, 5);
INSERT INTO sdassigment1.userpackages (UserID, PackageID) VALUES (8, 5);
INSERT INTO sdassigment1.userpackages (UserID, PackageID) VALUES (8, 5);
INSERT INTO sdassigment1.userpackages (UserID, PackageID) VALUES (13, 1);
INSERT INTO sdassigment1.userpackages (UserID, PackageID) VALUES (13, 1);
INSERT INTO sdassigment1.userpackages (UserID, PackageID) VALUES (13, 1);
INSERT INTO sdassigment1.userpackages (UserID, PackageID) VALUES (13, 1);
INSERT INTO sdassigment1.userpackages (UserID, PackageID) VALUES (13, 1);
INSERT INTO sdassigment1.userpackages (UserID, PackageID) VALUES (13, 1);
INSERT INTO sdassigment1.userpackages (UserID, PackageID) VALUES (13, 1);
INSERT INTO sdassigment1.userpackages (UserID, PackageID) VALUES (13, 1);
INSERT INTO sdassigment1.userpackages (UserID, PackageID) VALUES (13, 1);
INSERT INTO sdassigment1.userpackages (UserID, PackageID) VALUES (13, 1);
INSERT INTO sdassigment1.userpackages (UserID, PackageID) VALUES (13, 1);
INSERT INTO sdassigment1.userpackages (UserID, PackageID) VALUES (13, 1);
INSERT INTO sdassigment1.userpackages (UserID, PackageID) VALUES (13, 1);
INSERT INTO sdassigment1.userpackages (UserID, PackageID) VALUES (13, 1);
INSERT INTO sdassigment1.userpackages (UserID, PackageID) VALUES (13, 1);
INSERT INTO sdassigment1.userpackages (UserID, PackageID) VALUES (13, 1);
INSERT INTO sdassigment1.userpackages (UserID, PackageID) VALUES (13, 1);
INSERT INTO sdassigment1.userpackages (UserID, PackageID) VALUES (13, 1);
INSERT INTO sdassigment1.userpackages (UserID, PackageID) VALUES (13, 1);
INSERT INTO sdassigment1.userpackages (UserID, PackageID) VALUES (13, 1);