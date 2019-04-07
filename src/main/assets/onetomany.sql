use mydb;

create table contact(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(20)
);

create table phone_number(
id int PRIMARY KEY AUTO_INCREMENT,
contact_id int,
phonenumber varchar(20),
type varchar(20),
 FOREIGN KEY (contact_id)
REFERENCES contact(id)
);