drop database if exists test;
create database test;

use test;
create table orders (
id int primary key auto_increment,
item varchar(64),
amount int,
description varchar(128),
processed char(1)
)engine=innodb default charset=utf8;

