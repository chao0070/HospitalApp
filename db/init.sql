create table if not exists hospital (
   id int not null,
   name text not null,
   location text,
   timestamp bigint,
   primary key (id)
);

create table if not exists inventory_manager (
	id int not null,
	userid varchar(20) not null,
	password	varchar(256) not null,
	hospital_id int not null,
  primary key (id),
  foreign key (hospital_id) references hospital(id) on DELETE CASCADE
);

create table if not exists items (
  id int not null,
  name text not null,
  primary key (id)
);

create table if not exists hospital_item_inventory (
  hospital_id int not null,
  item_id int not null,
  inventory int not null,
  primary key (hospital_id, item_id),
  foreign key (hospital_id) references hospital(id) on DELETE CASCADE,
  foreign key (item_id) references items(id) on DELETE CASCADE
);
