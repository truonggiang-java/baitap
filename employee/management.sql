create database management;
use management;
create table users(
	id int not null auto_increment,
    name varchar(50) not null,
    email varchar(100) not null,
    password varchar(100) not null,
    is_active tinyint(1),
    phone varchar(11),
    address varchar(200),
    primary key(id)
);
Select e.id as id,e.lastname as ho,e.firstname as ten,e.email as email, e.address as address,d.name as name,p.name_position as name from employee e inner join department d on e.department_id=d.id inner join positionvp p on e.position_id=p.id;
create table employee(
	id int not null auto_increment,
    lastName varchar(50) not null,
    firstName varchar(50) not null,
    email varchar(50) not null,
    address varchar(60) not null,
    phone varchar(11),
    sex varchar(50),
    jobTitle varchar(50),
    department_id int,
    position_id int,
    primary key(id)
);

create table department(
	id int not null auto_increment,
    name varchar(100) not null,
    SDTPB varchar(11),
    address varchar(100),
    corePB varchar(50) not null,
    primary key(id)
);

create table positionVP(
	id int not null auto_increment,
    name_position varchar(100) not null,
    primary key(id)
);

create table groups_employee(
	id int not null auto_increment,
    primary key(id),
    employee_id int,
    name varchar(50),
    create_date timestamp,
    foreign key(employee_id) references employee(id)
)