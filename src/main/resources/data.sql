/*
create table person
(
    id integer not null,
    name varchar(255) not null,
    location varchar(255),
    birth_date timestamp,
    primary key(id)
);

Insert Into Person(ID, NAME, LOCATION, BIRTH_DATE)
values (10001, 'Claus', 'Forchheim',sysdate());
Insert Into Person(ID, NAME, LOCATION, BIRTH_DATE)
values (10002, 'Philipp', 'Forchheim',sysdate());
Insert Into Person(ID, NAME, LOCATION, BIRTH_DATE)
values (10003, 'Hannah', 'Forchheim',sysdate());
*/

Insert Into Course (ID, NAME)
values (10001, 'Claus Course');

Insert Into Course (ID, NAME)
values (10002, 'Claus Course1');

Insert Into Course (ID, NAME)
values (10003, 'Claus Course2');