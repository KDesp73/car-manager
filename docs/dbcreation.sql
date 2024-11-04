-- DROP SCHEMA "CarManager_DB";

CREATE SCHEMA "CarManager_DB" AUTHORIZATION iee2021035;

-- DROP SEQUENCE car_id_seq;

CREATE SEQUENCE car_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE customer_id_seq;

CREATE SEQUENCE customer_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE employee_id_seq;

CREATE SEQUENCE employee_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE manufacturer_id_seq;

CREATE SEQUENCE manufacturer_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE model_id_seq;

CREATE SEQUENCE model_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE person_id_seq;

CREATE SEQUENCE person_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE sales_id_seq;

CREATE SEQUENCE sales_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE service_id_seq;

CREATE SEQUENCE service_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;-- "CarManager_DB".manufacturer definition

-- Drop table

-- DROP TABLE manufacturer;

CREATE TABLE manufacturer (
	"name" varchar NOT NULL,
	"location" varchar NOT NULL,
	id int4 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE) NOT NULL,
	CONSTRAINT manufacturer_pk PRIMARY KEY (id),
	CONSTRAINT manufacturer_unique UNIQUE (name)
);


-- "CarManager_DB".person definition

-- Drop table

-- DROP TABLE person;

CREATE TABLE person (
	fname varchar NOT NULL,
	lname varchar NOT NULL,
	birth_year varchar NOT NULL,
	gender int4 NOT NULL,
	email varchar NOT NULL,
	id int4 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE) NOT NULL,
	CONSTRAINT person_pk PRIMARY KEY (id),
	CONSTRAINT person_unique UNIQUE (email)
);


-- "CarManager_DB".service definition

-- Drop table

-- DROP TABLE service;

CREATE TABLE service (
	tires bool DEFAULT false NULL,
	engine bool DEFAULT false NULL,
	brakes bool DEFAULT false NULL,
	oil bool DEFAULT false NULL,
	battery bool DEFAULT false NULL,
	id int4 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE) NOT NULL,
	"date" date NOT NULL,
	CONSTRAINT service_pk PRIMARY KEY (id)
);


-- "CarManager_DB".customer definition

-- Drop table

-- DROP TABLE customer;

CREATE TABLE customer (
	"uuid" uuid NOT NULL,
	id int4 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE) NOT NULL,
	CONSTRAINT customer_pk PRIMARY KEY (id),
	CONSTRAINT customer_unique UNIQUE (uuid),
	CONSTRAINT customer_person_fk FOREIGN KEY (id) REFERENCES person(id)
);


-- "CarManager_DB".employee definition

-- Drop table

-- DROP TABLE employee;

CREATE TABLE employee (
	salary money NOT NULL,
	id int4 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE) NOT NULL,
	CONSTRAINT employee_pk PRIMARY KEY (id),
	CONSTRAINT employee_person_fk FOREIGN KEY (id) REFERENCES person(id)
);


-- "CarManager_DB".model definition

-- Drop table

-- DROP TABLE model;

CREATE TABLE model (
	"type" int4 DEFAULT 0 NULL,
	"year" int4 NOT NULL,
	hp int4 NOT NULL,
	wd int4 DEFAULT 0 NULL,
	id int4 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE) NOT NULL,
	"name" varchar NOT NULL,
	CONSTRAINT model_pk PRIMARY KEY (id),
	CONSTRAINT model_manufacturer_fk FOREIGN KEY (id) REFERENCES manufacturer(id)
);


-- "CarManager_DB".car definition

-- Drop table

-- DROP TABLE car;

CREATE TABLE car (
	license_plate varchar NOT NULL,
	id int4 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE) NOT NULL,
	price money NOT NULL,
	CONSTRAINT car_pk PRIMARY KEY (id),
	CONSTRAINT car_unique UNIQUE (license_plate),
	CONSTRAINT car_model_fk FOREIGN KEY (id) REFERENCES model(id),
	CONSTRAINT car_service_fk FOREIGN KEY (id) REFERENCES service(id)
);


-- "CarManager_DB".sales definition

-- Drop table

-- DROP TABLE sales;

CREATE TABLE sales (
	id int4 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE) NOT NULL,
	discount numeric DEFAULT 0.0 NULL,
	price money NOT NULL,
	"date" date NOT NULL,
	CONSTRAINT sales_car_fk FOREIGN KEY (id) REFERENCES car(id),
	CONSTRAINT sales_customer_fk FOREIGN KEY (id) REFERENCES customer(id),
	CONSTRAINT sales_employee_fk FOREIGN KEY (id) REFERENCES employee(id)
);



-- DROP PROCEDURE "CarManager_DB".delete_manufacturer(int4);

CREATE OR REPLACE PROCEDURE "CarManager_DB".delete_manufacturer(IN param_id integer)
 LANGUAGE plpgsql
AS $procedure$
	BEGIN
		DELETE FROM Manufacturer WHERE id = param_id;
	END;
$procedure$
;

-- DROP PROCEDURE "CarManager_DB".delete_manufacturer(varchar);

CREATE OR REPLACE PROCEDURE "CarManager_DB".delete_manufacturer(IN param_name character varying)
 LANGUAGE plpgsql
AS $procedure$
	BEGIN
		DELETE FROM Manufacturer WHERE name = param_name;
	END;
$procedure$
;

-- DROP FUNCTION "CarManager_DB".get_columns(text);

CREATE OR REPLACE FUNCTION "CarManager_DB".get_columns(t_name text)
 RETURNS TABLE(column_name text)
 LANGUAGE plpgsql
AS $function$
begin
     return query (
         select column_name from information_schema.columns where table_name = t_name
     );
 end;
$function$
;

-- DROP FUNCTION "CarManager_DB".get_first_table();

CREATE OR REPLACE FUNCTION "CarManager_DB".get_first_table()
 RETURNS text
 LANGUAGE plpgsql
AS $function$
begin
	select * from get_tables() LIMIT 1 ;
end;
$function$
;

-- DROP FUNCTION "CarManager_DB".get_table(int4);

CREATE OR REPLACE FUNCTION "CarManager_DB".get_table(index integer)
 RETURNS text
 LANGUAGE plpgsql
AS $function$
begin
     select * from get_tables() LIMIT 1 OFFSET index - 1;
end;
$function$
;

-- DROP FUNCTION "CarManager_DB".get_tables();

CREATE OR REPLACE FUNCTION "CarManager_DB".get_tables()
 RETURNS TABLE(t_name text)
 LANGUAGE plpgsql
AS $function$
begin
    return query (
        select table_name::text from information_schema.tables where table_schema = 'CarManager-DB'
    );
end;
$function$
;

-- DROP PROCEDURE "CarManager_DB".insert_manufacturer(varchar, varchar);

CREATE OR REPLACE PROCEDURE "CarManager_DB".insert_manufacturer(IN param_name character varying, IN param_location character varying)
 LANGUAGE plpgsql
AS $procedure$
BEGIN
    INSERT INTO Manufacturer (name, location) VALUES (param_name, param_location);
END;
$procedure$
;

-- DROP PROCEDURE "CarManager_DB".populate_manufacturer();

CREATE OR REPLACE PROCEDURE "CarManager_DB".populate_manufacturer()
 LANGUAGE plpgsql
AS $procedure$
BEGIN
    INSERT INTO Manufacturer (name, location) VALUES ('Ford', 'USA');
    INSERT INTO Manufacturer (name, location) VALUES ('Toyota', 'Japan');
    INSERT INTO Manufacturer (name, location) VALUES ('Volkswagen', 'Germany');
    INSERT INTO Manufacturer (name, location) VALUES ('Hyundai', 'South Korea');
    INSERT INTO Manufacturer (name, location) VALUES ('BMW', 'Germany');
    INSERT INTO Manufacturer (name, location) VALUES ('Honda', 'Japan');
    INSERT INTO Manufacturer (name, location) VALUES ('Nissan', 'Japan');
    INSERT INTO Manufacturer (name, location) VALUES ('Chevrolet', 'USA');
    INSERT INTO Manufacturer (name, location) VALUES ('Mercedes-Benz', 'Germany');
    INSERT INTO Manufacturer (name, location) VALUES ('Audi', 'Germany');
    INSERT INTO Manufacturer (name, location) VALUES ('Kia', 'South Korea');
    INSERT INTO Manufacturer (name, location) VALUES ('Renault', 'France');
    INSERT INTO Manufacturer (name, location) VALUES ('Peugeot', 'France');
    INSERT INTO Manufacturer (name, location) VALUES ('Fiat', 'Italy');
    INSERT INTO Manufacturer (name, location) VALUES ('Porsche', 'Germany');
    INSERT INTO Manufacturer (name, location) VALUES ('Jeep', 'USA');
    INSERT INTO Manufacturer (name, location) VALUES ('Mazda', 'Japan');
    INSERT INTO Manufacturer (name, location) VALUES ('Subaru', 'Japan');
    INSERT INTO Manufacturer (name, location) VALUES ('Land Rover', 'UK');
    INSERT INTO Manufacturer (name, location) VALUES ('Jaguar', 'UK');
    INSERT INTO Manufacturer (name, location) VALUES ('Volvo', 'Sweden');
    INSERT INTO Manufacturer (name, location) VALUES ('Tesla', 'USA');
    INSERT INTO Manufacturer (name, location) VALUES ('Ferrari', 'Italy');
    INSERT INTO Manufacturer (name, location) VALUES ('Lamborghini', 'Italy');
    INSERT INTO Manufacturer (name, location) VALUES ('Maserati', 'Italy');
    INSERT INTO Manufacturer (name, location) VALUES ('Bentley', 'UK');
    INSERT INTO Manufacturer (name, location) VALUES ('Rolls-Royce', 'UK');
    INSERT INTO Manufacturer (name, location) VALUES ('Saab', 'Sweden');
    INSERT INTO Manufacturer (name, location) VALUES ('Opel', 'Germany');
    INSERT INTO Manufacturer (name, location) VALUES ('Citroën', 'France');
    INSERT INTO Manufacturer (name, location) VALUES ('Alfa Romeo', 'Italy');
    INSERT INTO Manufacturer (name, location) VALUES ('Dacia', 'Romania');
    INSERT INTO Manufacturer (name, location) VALUES ('Tata Motors', 'India');
    INSERT INTO Manufacturer (name, location) VALUES ('Mahindra', 'India');
    INSERT INTO Manufacturer (name, location) VALUES ('Chery', 'China');
    INSERT INTO Manufacturer (name, location) VALUES ('Geely', 'China');
    INSERT INTO Manufacturer (name, location) VALUES ('BYD', 'China');
    INSERT INTO Manufacturer (name, location) VALUES ('Holden', 'Australia');
    INSERT INTO Manufacturer (name, location) VALUES ('Seat', 'Spain');

END
$procedure$
;

-- DROP FUNCTION "CarManager_DB".select_all_manufacturers();

CREATE OR REPLACE FUNCTION "CarManager_DB".select_all_manufacturers()
 RETURNS SETOF "CarManager_DB".manufacturer
 LANGUAGE plpgsql
AS $function$
BEGIN
    RETURN QUERY
    SELECT *
    FROM "CarManager_DB".Manufacturer;
END;
$function$
;

-- DROP FUNCTION "CarManager_DB".select_car(int4);

CREATE OR REPLACE FUNCTION "CarManager_DB".select_car(_car_id integer)
 RETURNS TABLE(car_licence_plate character varying, car_id integer, car_price money)
 LANGUAGE plpgsql
AS $function$
	begin
	return query (
		select * from "CarManager_DB".Car where id = _car_id
	);
end;
$function$
;

-- DROP FUNCTION "CarManager_DB".select_customer(int4);

CREATE OR REPLACE FUNCTION "CarManager_DB".select_customer(_customer_id integer)
 RETURNS TABLE(customer_uui uuid, customer_id integer)
 LANGUAGE plpgsql
AS $function$
	begin
	return query (
		select * from "CarManager-DB".Customer where id = _customer_id
	);
end;
$function$
;

-- DROP FUNCTION "CarManager_DB".select_employee(int4);

CREATE OR REPLACE FUNCTION "CarManager_DB".select_employee(_employee_id integer)
 RETURNS TABLE(employee_salary money, employee_id integer)
 LANGUAGE plpgsql
AS $function$
	begin
	return query (
		select * from "CarManager-DB".Emloyee where id = _employee_id
	);
end;
$function$
;

-- DROP FUNCTION "CarManager_DB".select_manufacturer(int4);

CREATE OR REPLACE FUNCTION "CarManager_DB".select_manufacturer(_manufacturer_id integer)
 RETURNS TABLE(manufacturer_name character varying, manufacturer_location character varying, manufacturer_id integer)
 LANGUAGE plpgsql
AS $function$
	begin
	return query (
		select * from "CarManager-DB".Manufacturer where id = _manufacturer_id
	);
end;
$function$
;

-- DROP FUNCTION "CarManager_DB".select_model(int4);

CREATE OR REPLACE FUNCTION "CarManager_DB".select_model(_model_id integer)
 RETURNS TABLE(model_type integer, model_year integer, model_hp integer, model_wd integer, model_id integer, model_name character varying)
 LANGUAGE plpgsql
AS $function$
	begin
	return query (
		select * from "CarManager-DB".Model where id = _model_id
	);
end;
$function$
;

-- DROP FUNCTION "CarManager_DB".select_person(int4);

CREATE OR REPLACE FUNCTION "CarManager_DB".select_person(_person_id integer)
 RETURNS TABLE(person_fname character varying, person_lname character varying, person_birth_year character varying, person_gender integer, person_email character varying, person_id character varying)
 LANGUAGE plpgsql
AS $function$
	begin
	return query (
		select * from "CarManager-DB".Person where id = _person_id
	);
end;
$function$
;

-- DROP FUNCTION "CarManager_DB".select_sales(int4);

CREATE OR REPLACE FUNCTION "CarManager_DB".select_sales(_sales_id integer)
 RETURNS TABLE(sales_id integer, sales_discount numeric, sales_price money, sales_date date)
 LANGUAGE plpgsql
AS $function$
	begin
	return query (
		select * from "CarManager-DB".Sales where id = _sales_id
	);
end;
$function$
;

-- DROP FUNCTION "CarManager_DB".select_service(int4);

CREATE OR REPLACE FUNCTION "CarManager_DB".select_service(_service_id integer)
 RETURNS TABLE(service_tires boolean, service_engine boolean, service_brakes boolean, service_oil boolean, service_battery boolean, service_id integer, service_date date)
 LANGUAGE plpgsql
AS $function$
	begin
	return query (
		select * from "CarManager-DB".Service where id = _service_id
	);
end;
$function$
;

-- DROP PROCEDURE "CarManager_DB".update_manufacturer(int4, varchar, varchar);

CREATE OR REPLACE PROCEDURE "CarManager_DB".update_manufacturer(IN param_id integer, IN param_name character varying, IN param_location character varying)
 LANGUAGE plpgsql
AS $procedure$
	BEGIN
		UPDATE Manufacturer SET name = param_name, location = param_location WHERE id = param_id;
	END;
$procedure$
;
