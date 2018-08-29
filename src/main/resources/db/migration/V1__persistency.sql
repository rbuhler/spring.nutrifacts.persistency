CREATE SCHEMA if NOT EXISTS public;

create table if NOT EXISTS item (
    INDEX           bigserial PRIMARY KEY,
    BARCODE         VARCHAR(255),
    IDENTIFICATION  VARCHAR(255),
    QUANTITY        INTEGER,
    UNITOFMEASURE   VARCHAR(255),
    IMAGE           VARCHAR(255)
);

create table unitofmeasure (
    INDEX           bigserial PRIMARY KEY,
    SHORTID         VARCHAR(255),
    DESCRIPTION     VARCHAR(255),
    GREATNESS       VARCHAR(255)
);

create table if NOT EXISTS manufacturer (
    INDEX           bigserial PRIMARY KEY,
    COMERCIAL_NAME  VARCHAR(255),
    BUSINESS_NAME   VARCHAR(255),
);

create table if NOT EXISTS company (
    INDEX           bigserial PRIMARY KEY,
    COMERCIAL_NAME  VARCHAR(255),
    BUSINESS_NAME   VARCHAR(255),
);