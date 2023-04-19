--liquibase formatted sql

--changeset kkc:1
create table request_registry
(
    login         varchar(255) not null primary key,
    request_count integer not null
);

--changeset kkc:2
alter table request_registry
    owner to postgresql;