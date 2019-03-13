use mydb;

create table licenseplate(
id int PRIMARY KEY,
code varchar(10),
length integer(2)
);

insert into licenseplate(id, code, length) values (1, "WE 12345", 7);
insert into licenseplate(id, code, length) values (2, "WZ 12345", 7);
insert into licenseplate(id, code, length) values (3, "WY 12345", 7);
insert into licenseplate(id, code, length) values (4, "WW 12345", 7);
insert into licenseplate(id, code, length) values (5, "WZY 12345", 8);
insert into licenseplate(id, code, length) values (6, "LLU 12345", 8);
insert into licenseplate(id, code, length) values (7, "WR 12345", 7);