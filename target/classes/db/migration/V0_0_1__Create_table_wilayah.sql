/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  iqbal
 * Created: Feb 12, 2018
 */

CREATE SCHEMA wilayah;
create table wilayah.master_provinsi(
  kode_provinsi CHARACTER VARYING(255) not null unique primary key,
  nama_provinsi CHARACTER VARYING(50) not null,
  created_date TIMESTAMP not null,
  created_by CHARACTER VARYING(20)
);

create table wilayah.master_kota_kabupaten(
  kode_kota CHARACTER VARYING(255) not null UNIQUE  primary key,
  nama_kota CHARACTER VARYING(50) not null,
  created_date TIMESTAMP not null,
  created_by CHARACTER VARYING(20),
  provinsi_id CHARACTER VARYING(255) not null
);

ALTER TABLE wilayah.master_kota_kabupaten
  ADD CONSTRAINT fk_provinsi_kota FOREIGN KEY(provinsi_id) REFERENCES wilayah.master_provinsi(kode_provinsi)
ON UPDATE RESTRICT ON DELETE RESTRICT;

CREATE TABLE wilayah.kecamatan_bandung (
id_kecamatan  CHARACTER VARYING(50) primary key not null,
nama_kecamatan  CHARACTER VARYING(50)  NOT NULL UNIQUE,
kode_pos CHARACTER VARYING(10),
created_by CHARACTER VARYING(20),
kabupaten_id CHARACTER VARYING(255) not null
);

ALTER TABLE wilayah.kecamatan_bandung
ADD CONSTRAINT fk_kota_kecamatan FOREIGN KEY (kabupaten_id)
REFERENCES wilayah.master_kota_kabupaten (kode_kota)
ON UPDATE RESTRICT ON DELETE RESTRICT;

CREATE TABLE wilayah.kelurahan_bandung (
id_kelurahan  CHARACTER VARYING(50) primary key not null,
nama_kelurahan  CHARACTER VARYING(50)  NOT NULL UNIQUE,
kode_pos_kel CHARACTER VARYING(10),
kecamatan_id CHARACTER VARYING(255) not null
);

ALTER TABLE wilayah.kelurahan_bandung
ADD CONSTRAINT fk_kelurahan_kecamatan FOREIGN KEY (kecamatan_id)
REFERENCES wilayah.kecamatan_bandung (id_kecamatan)
ON UPDATE RESTRICT ON DELETE RESTRICT;




