create table products (id bigint not null auto_increment, date date, description varchar(255), file_name varchar(255), name varchar(255), price integer, status varchar(255), owner_id bigint, primary key (id)) engine=MyISAM;
create table users (id bigint not null auto_increment, activated BOOLEAN DEFAULT false, activation_code varchar(255), email varchar(255) not null, first_name varchar(255), password varchar(255) not null, last_name varchar(255), login varchar(255) not null, role varchar(255), state varchar(255), uploadphoto varchar(255), primary key (id)) engine=MyISAM;
alter table products add constraint FKmodgy1j6kai83i3mweyp731qc foreign key (owner_id) references users (id);
CREATE TABLE IF NOT EXISTS persistent_logins (
  username  VARCHAR(64) NOT NULL,
  series    VARCHAR(64) NOT NULL,
  token     VARCHAR(64) NOT NULL,
  last_used TIMESTAMP   NOT NULL,
  PRIMARY KEY (series)
);