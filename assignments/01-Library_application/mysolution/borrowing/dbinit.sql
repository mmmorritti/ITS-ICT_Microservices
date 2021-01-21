CREATE DATABASE "borrowing" OWNER postgres;
\connect borrowing
ALTER DATABASE "borrowing" SET TIMEZONE TO 'Europe/Rome';
SET TIMEZONE TO 'Europe/Rome';

CREATE TABLE "borrowings"
(
    borrowing_id integer,
    start_borrow character varying,
    end_borrow character varying,
    book integer,
    customer integer,
    notify character varying
) TABLESPACE pg_default;

ALTER TABLE "borrowings"
    OWNER to postgres;