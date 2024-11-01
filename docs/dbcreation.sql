-- DROP SCHEMA "CarManager-DB";

CREATE SCHEMA "CarManager-DB" AUTHORIZATION iee2021035;
-- "CarManager-DB".manufacturer definition

-- Drop table

-- DROP TABLE manufacturer;

CREATE TABLE manufacturer (
	"name" varchar NOT NULL,
	id int4 NOT NULL,
	"location" varchar NOT NULL,
	CONSTRAINT manufacturer_pk PRIMARY KEY (id),
	CONSTRAINT manufacturer_unique UNIQUE (name)
);


-- "CarManager-DB".service definition

-- Drop table

-- DROP TABLE service;

CREATE TABLE service (
	tires bool DEFAULT false NULL,
	engine bool DEFAULT false NULL,
	brakes bool DEFAULT false NULL,
	oil bool DEFAULT false NULL,
	battery bool DEFAULT false NULL,
	id int4 NOT NULL,
	CONSTRAINT service_pk PRIMARY KEY (id)
);


-- "CarManager-DB".person definition

-- Drop table

-- DROP TABLE person;

CREATE TABLE person (
	fname varchar NOT NULL,
	lname varchar NOT NULL,
	birth_year varchar NOT NULL,
	gender int4 NOT NULL,
	email varchar NOT NULL,
	id int4 NOT NULL,
	CONSTRAINT person_pk PRIMARY KEY (id),
	CONSTRAINT person_unique UNIQUE (email)
);


-- "CarManager-DB".car definition

-- Drop table

-- DROP TABLE car;

CREATE TABLE car (
	model varchar NOT NULL,
	"type" int4 NULL,
	"year" int4 NOT NULL,
	id int4 NOT NULL,
	price money NOT NULL,
	hp int4 NOT NULL,
	license_plate varchar NOT NULL,
	wd int4 NULL,
	CONSTRAINT car_pk PRIMARY KEY (id),
	CONSTRAINT car_unique UNIQUE (license_plate),
	CONSTRAINT car_manufacturer_fk FOREIGN KEY (id) REFERENCES manufacturer(id),
	CONSTRAINT car_service_fk FOREIGN KEY (id) REFERENCES service(id)
);


-- "CarManager-DB".customer definition

-- Drop table

-- DROP TABLE customer;

CREATE TABLE customer (
	id int4 NOT NULL,
	"uuid" uuid NOT NULL,
	CONSTRAINT customer_pk PRIMARY KEY (id),
	CONSTRAINT customer_unique UNIQUE (uuid),
	CONSTRAINT customer_person_fk FOREIGN KEY (id) REFERENCES person(id)
);


-- "CarManager-DB".employee definition

-- Drop table

-- DROP TABLE employee;

CREATE TABLE employee (
	id int4 NOT NULL,
	salary money NOT NULL,
	CONSTRAINT employee_pk PRIMARY KEY (id),
	CONSTRAINT employee_person_fk FOREIGN KEY (id) REFERENCES person(id)
);


-- "CarManager-DB".sales definition

-- Drop table

-- DROP TABLE sales;

CREATE TABLE sales (
	id int4 NOT NULL,
	discount numeric DEFAULT 0.0 NULL,
	CONSTRAINT sales_pk PRIMARY KEY (id),
	CONSTRAINT sales_car_fk FOREIGN KEY (id) REFERENCES car(id),
	CONSTRAINT sales_customer_fk FOREIGN KEY (id) REFERENCES customer(id),
	CONSTRAINT sales_employee_fk FOREIGN KEY (id) REFERENCES employee(id)
);