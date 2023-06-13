CREATE SCHEMA `new_schema` DEFAULT CHARACTER SET utf8 ;

create table employee
(
    id bigint auto_increment primary key,
    first_name varchar(254),
    last_name varchar(254),
    email varchar(45) not null,
    age int
);


create table specialization
(
    id bigint auto_increment primary key,
    name varchar(254) not null
);


create table specialization_employee
(
   specialization_id bigint not null,
   employee_id bigint not null,
   primary key (specialization_id, employee_id),
   foreign key (specialization_id) references specialization(id),
   foreign key (employee_id) references employee(id)
);