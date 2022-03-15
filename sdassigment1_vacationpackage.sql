create table vacationpackage
(
    ID              int auto_increment,
    name            varchar(255) not null,
    price           int          null,
    extra_details   varchar(255) null,
    start_date      date         null,
    end_date        date         null,
    slots_available int          null,
    destination     int          null,
    total_slots     int          null,
    constraint VacationPackage_ID_uindex
        unique (ID),
    constraint vacationpackage_destinations_ID_fk
        foreign key (destination) references destinations (ID)
);

create index ID
    on vacationpackage (ID);

INSERT INTO sdassigment1.vacationpackage (ID, name, price, extra_details, start_date, end_date, slots_available, destination, total_slots) VALUES (1, 'ItalyCityBreak', 400.23, 'Your chance to visit Italy for a cheap price!', '2022-03-12', '2022-03-13', 0, 1, 20);
INSERT INTO sdassigment1.vacationpackage (ID, name, price, extra_details, start_date, end_date, slots_available, destination, total_slots) VALUES (2, 'Bucovinaa', 70.1, 'Visit Bucovina for 5 days!', '2022-06-13', '2022-06-20', 42, 2, 42);
INSERT INTO sdassigment1.vacationpackage (ID, name, price, extra_details, start_date, end_date, slots_available, destination, total_slots) VALUES (3, 'ParisNow', 623.99, 'Eiffel Tower!', '2022-09-07', '2022-09-10', 96, 3, 96);
INSERT INTO sdassigment1.vacationpackage (ID, name, price, extra_details, start_date, end_date, slots_available, destination, total_slots) VALUES (4, 'DublinVisit', 1000.99, 'You can visit Dublin and anything around it!', '2022-10-11', '2022-10-18', 5, 4, 5);
INSERT INTO sdassigment1.vacationpackage (ID, name, price, extra_details, start_date, end_date, slots_available, destination, total_slots) VALUES (5, 'VisitUSANow!', 2000.98, 'Your best trip to the USA.', '2022-05-09', '2022-05-16', 0, 5, 3);
INSERT INTO sdassigment1.vacationpackage (ID, name, price, extra_details, start_date, end_date, slots_available, destination, total_slots) VALUES (6, 'ParisIsYours', 1000.12, 'Paris is at your feet!', '2022-08-08', '2022-08-15', 10, 3, 10);