CREATE SCHEMA nasabah;
CREATE TABLE nasabah.master_agama (
  kode_agama   CHARACTER VARYING(255) NOT NULL PRIMARY KEY,
  nama_agama   CHARACTER VARYING(50)  NOT NULL UNIQUE,
  deskripsi    CHARACTER VARYING(255),
  created_date TIMESTAMP              NOT NULL,
  created_by   CHARACTER VARYING(50)
);


