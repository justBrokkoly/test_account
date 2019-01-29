CREATE DATABASE  IF NOT EXISTS test_account
USE test_account;

DROP TABLE IF EXISTS account ;

create table account(
id int AUTO_INCREMENT PRIMARY KEY,
first_name varchar(30),
last_name varchar(30),
unique(first_name)
);

Insert into account set 
id = 1,
first_name= "kirill",
last_name= "kustov"

Insert into account set 
id = 2,
first_name= "Dmitry",
last_name= "Petrov"

Insert into account set 
id = 3,
first_name= "John",
last_name= "Wick"

DROP DATABASE test_account
