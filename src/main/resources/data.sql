-- DROP SCHEMA "spring-class";

CREATE SCHEMA "spring-class" AUTHORIZATION postgres;

-- DROP SEQUENCE "spring-class".permission_id_seq;

CREATE SEQUENCE "spring-class".permission_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE "spring-class".user_permission_id_seq;

CREATE SEQUENCE "spring-class".user_permission_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE "spring-class".users_id_seq;

CREATE SEQUENCE "spring-class".users_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    START 1
	CACHE 1
	NO CYCLE;-- "spring-class"."permission" definition

-- Drop table

-- DROP TABLE "spring-class"."permission";

CREATE TABLE "spring-class"."permission" (
                                             id serial4 NOT NULL,
                                             "name" varchar(255) NULL,
                                             CONSTRAINT permission_pkey PRIMARY KEY (id)
);


-- "spring-class".users definition

-- Drop table

-- DROP TABLE "spring-class".users;

CREATE TABLE "spring-class".users (
                                      id serial4 NOT NULL,
                                      "name" varchar(255) NULL,
                                      CONSTRAINT users_pkey PRIMARY KEY (id)
);


-- "spring-class".user_permission definition

-- Drop table

-- DROP TABLE "spring-class".user_permission;

CREATE TABLE "spring-class".user_permission (
                                                id serial4 NOT NULL,
                                                permission_id int4 NOT NULL,
                                                user_id int4 NOT NULL,
                                                CONSTRAINT user_permission_pkey PRIMARY KEY (id),
                                                CONSTRAINT fkbklmo9kchans5u3e4va0ouo1s FOREIGN KEY (permission_id) REFERENCES "spring-class"."permission"(id),
                                                CONSTRAINT fkn8ba4v3gvw1d82t3hofelr82t FOREIGN KEY (user_id) REFERENCES "spring-class".users(id)
);


