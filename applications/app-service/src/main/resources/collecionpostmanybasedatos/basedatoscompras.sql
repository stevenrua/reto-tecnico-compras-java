-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION pg_database_owner;

COMMENT ON SCHEMA public IS 'standard public schema';

-- DROP SEQUENCE public.buys_id_seq;

CREATE SEQUENCE public.buys_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.detail_id_seq;

CREATE SEQUENCE public.detail_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.products_id_seq;

CREATE SEQUENCE public.products_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;-- public.buys definition

-- Drop table

-- DROP TABLE public.buys;

CREATE TABLE public.buys (
	id serial4 NOT NULL,
	"identity" int4 NULL,
	"date" timestamp NULL,
	idtype varchar(255) NULL,
	clientname varchar(255) NULL,
	CONSTRAINT buys_pkey PRIMARY KEY (id)
);


-- public.detail definition

-- Drop table

-- DROP TABLE public.detail;

CREATE TABLE public.detail (
	id serial4 NOT NULL,
	buyid int4 NULL,
	productid int4 NULL,
	quantity int4 NULL,
	CONSTRAINT detail_pkey PRIMARY KEY (id)
);


-- public.products definition

-- Drop table

-- DROP TABLE public.products;

CREATE TABLE public.products (
	id serial4 NOT NULL,
	"name" varchar(50) NOT NULL,
	ininventory int4 NOT NULL,
	enabled bool NOT NULL,
	min int4 NOT NULL,
	max int4 NOT NULL,
	CONSTRAINT products_name_key UNIQUE (name),
	CONSTRAINT products_pkey PRIMARY KEY (id)
);
