-- Define certain unique keys
-- DEfine certain indexes

create table if not exists  (
   id serial not null,
   name text not null,
   location text,
   timestamp bigint,
   primary key (id)
);
-- Modify initial value and increment
ALTER SEQUENCE hospital_id_seq RESTART WITH 1 INCREMENT BY 1;

create table if not exists inventory_manager (
	id serial not null,
	userid varchar(20) not null,
	password	varchar(256) not null,
	hospital_id int not null,
  primary key (id),
  foreign key (hospital_id) references hospital(id) on DELETE CASCADE
);
-- Modify initial value and increment
ALTER SEQUENCE inventory_manager_id_seq RESTART WITH 1 INCREMENT BY 1;

create table if not exists items (
  id serial not null,
  name text not null,
  primary key (id)
);
ALTER SEQUENCE items_id_seq RESTART WITH 1 INCREMENT BY 1;

create table if not exists hospital_item_inventory (
  hospital_id int not null,
  item_id int not null,
  inventory int not null,
  primary key (hospital_id, item_id),
  foreign key (hospital_id) references hospital(id) on DELETE CASCADE,
  foreign key (item_id) references items(id) on DELETE CASCADE
);
