 Drop table if exists employee;
 create table employee (
       id varchar(255) not null,
        age integer not null,
        joiningDate date,
        firstName varchar(255),
        lastName varchar(255),
        email varchar(255),
        title varchar(255),
        primary key (id)
    );