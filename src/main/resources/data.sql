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

Insert Into Passport (ID, NUMBER)
values (40001, 'E123456');
Insert Into Passport (ID, NUMBER)
values (40002, 'D123456');
Insert Into Passport (ID, NUMBER)
values (40003, 'F123456');
Insert Into Passport (ID, NUMBER)
values (40004, 'G123456');

Insert Into Student (ID, NAME, PASSPORT_ID)
values (20001, 'Claus',40001);
Insert Into Student (ID, NAME, PASSPORT_ID)
values (20002, 'Philipp',40002);
Insert Into Student (ID, NAME, PASSPORT_ID)
values (20003, 'Hannah',40003);
Insert Into Student (ID, NAME, PASSPORT_ID)
values (20004, 'Tanja',40004);


Insert Into Review (ID, RATING, DESCRIPTION, course_id)
values (50001, '1', 'SUPER', 10001);
Insert Into Review (ID, RATING, DESCRIPTION, course_id)
values (50002, '2', 'SUPER', 10001);
Insert Into Review (ID, RATING, DESCRIPTION, course_id)
values (50003, '3', 'SUPER', 10001);
Insert Into Review (ID, RATING, DESCRIPTION, course_id)
values (50004, '4', 'SUPER', 10003);

Insert Into student_course(student_id, course_id) values(20001, 10001);
Insert Into student_course(student_id, course_id) values(20002, 10001);
Insert Into student_course(student_id, course_id) values(20003, 10001);
Insert Into student_course(student_id, course_id) values(20001, 10003);