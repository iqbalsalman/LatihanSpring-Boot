-- drop tabel data master
-- create scheme master
CREATE SCHEMA master;
-- recreate table master
CREATE TABLE master.pendidikan (
  id           CHARACTER VARYING(225)   NOT NULL UNIQUE PRIMARY KEY,
  nama         CHARACTER VARYING(150) NOT NULL,
  created_date TIMESTAMP              NOT NULL,
  created_by   CHARACTER VARYING(255)
);
INSERT INTO master.pendidikan (id, nama, created_date, created_by)
VALUES ('sd', 'Sekolah dasar', now(), 'migration'),
  ('smp', 'Sekolah menengah pertama', now(), 'migration'),
  ('s1', 'Sarjana Strata 1', now(), 'migration');
CREATE TABLE master.kriteria_tabungan (
  id                 CHARACTER VARYING(64)  NOT NULL PRIMARY KEY,
  kode               CHARACTER VARYING(50)  NOT NULL UNIQUE,
  nama               CHARACTER VARYING(150) NOT NULL,
  suku_bunga         DOUBLE PRECISION       NOT NULL DEFAULT 0,
  setoran_awal       NUMERIC                NOT NULL DEFAULT 0,
  biaya_administrasi NUMERIC                NOT NULL DEFAULT 0,
  is_active          BOOLEAN                NOT NULL DEFAULT FALSE
);