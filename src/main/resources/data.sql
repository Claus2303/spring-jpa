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

Insert Into Course (ID, NAME, created_date, last_updated_date)
values (10001, 'Claus Course', sysdate(), sysdate());

Insert Into Course (ID, NAME, created_date, last_updated_date)
values (10002, 'Claus Course1',sysdate(), sysdate());

Insert Into Course (ID, NAME, created_date, last_updated_date)
values (10003, 'Claus Course2',sysdate(), sysdate());