create database MyJoinsDB;

use MyJoinsDB;

create table employees
(
id int auto_increment not null primary key,
name varchar(30),
phone varchar(15)
);

create table job
(
employee_id int primary key,
salary int,
job_title varchar(30),
foreign key (employee_id) references employees (id)
);

create table family
(
employee_id int primary key,
marital_status varchar(20),
birth date,
address varchar(50),
foreign key (employee_id) references employees (id)
);

insert into employees (name, phone) values
('Іванов І.І.', '+380121234567'),
('Пєтров П.П.', '+380125648547'),
('Сідоров І.С.', '+38012564987'),
('Воробей Д.Д', '+380121111111');

select * from employees;

insert into job (employee_id, salary, job_title) values
(1, 300, 'робітник'),
(2, 350, 'менеджер'),
(3, 700, 'головний директор'),
(4, 320, 'робітник');

select * from job;

insert into family (employee_id, marital_status, birth, address) values
(1, 'не одружений', '1980-01-01', 'вул. Вечірня 25/10'),
(2, 'одружений', '1979-08-03', 'вул. Правди 10/15'),
(3, 'одружений', '1991-12-12', 'вул. Поштова 1/10'),
(4, 'не одружений', '1999-07-21', 'вул. Південна 10');

select * from family;