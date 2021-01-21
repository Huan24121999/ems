create database ems;

use ems;

create table alarm(
id int auto_increment primary key
);

create table current_alarm(
id int auto_increment primary key,
alarm_id int,
keygen varchar(255),
message varchar(255),
create_time datetime,
repeat_count int,
foreign key(alarm_id) references alarm(id)
)
