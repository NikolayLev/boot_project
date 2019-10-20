alter table if exists products drop constraint if exists FKmodgy1j6kai83i3mweyp731qc;
drop table if exists products cascade;
drop table if exists users cascade;
create table products (id  bigserial not null, date date, description varchar(2048), file_name varchar(255), name varchar(255), price int4 not null, status varchar(255), owner_id int8, primary key (id));
create table users (id  bigserial not null, activated boolean, activation_code varchar(255), email varchar(255) not null, first_name varchar(255), hash_password varchar(255) not null, last_name varchar(255), login varchar(255) not null, role varchar(255), state varchar(255), uploadphoto varchar(255), primary key (id));
alter table if exists products add constraint FKmodgy1j6kai83i3mweyp731qc foreign key (owner_id) references users;
CREATE TABLE persistent_logins (
    username varchar(64) not null,
    series varchar(64) not null,
    token varchar(64) not null,
    last_used timestamp not null,
    PRIMARY KEY (series)
);