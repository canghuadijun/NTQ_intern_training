CREATE DATABASE if not exists mini_project;
use mini_project;

create table if not exists User(
	id bigint AUTO_INCREMENT PRIMARY KEY not null,
	username VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	role VARCHAR(255) NOT NULL
);