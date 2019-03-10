use mydb;

create table jpayment(
amount decimal(8,3),
id int PRIMARY KEY NOT NULL AUTO_INCREMENT
);

create table jcard(
id int,
cardnumber varchar(20),
 FOREIGN KEY (id)
REFERENCES jpayment(id)
);

create table jbankcheck(
id int,
checknumber varchar(20),
FOREIGN KEY (id)
REFERENCES jpayment(id)
);
