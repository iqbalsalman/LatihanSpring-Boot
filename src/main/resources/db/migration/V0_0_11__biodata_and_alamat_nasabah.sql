CREATE TABLE nasabah.biodata_nasabah(
  idbiodata         CHARACTER VARYING (50) PRIMARY KEY NOT NULL ,
  idnasabah         CHARACTER VARYING(64),
  tanda_pengenal    CHARACTER VARYING (50) NOT NULL ,
  no_pengenal       VARCHAR(50),
  berlaku_s_d       DATE NOT NULL DEFAULT now(),
  tempatlahir       CHARACTER VARYING (50),
  tanggallahir      DATE NOT NULL DEFAULT NOW(),
  status_perkawinan CHARACTER VARYING (20)
);

ALTER TABLE nasabah.biodata_nasabah
  ADD CONSTRAINT fk_biodata_nasabah FOREIGN KEY(idnasabah) REFERENCES nasabah.data_nasabah(nasabah_id)
ON UPDATE RESTRICT ON DELETE RESTRICT;


CREATE TABLE nasabah.alamat_rumah(
  idalamat  CHARACTER VARYING (50) PRIMARY KEY NOT NULL,
  agama     CHARACTER VARYING (50),
  kota      CHARACTER VARYING (50) NOT NULL ,
  kodepos   CHARACTER VARYING (10) NOT NULL ,
  no_tlp    CHARACTER VARYING (20) NOT NULL ,
  no_fax    CHARACTER VARYING (25),
  no_hp     CHARACTER VARYING (30),
  email     CHARACTER VARYING (50) NOT NULL,
  biodataid CHARACTER VARYING (50)
);

ALTER TABLE nasabah.alamat_rumah
  ADD CONSTRAINT fk_biodata_aalamat FOREIGN KEY(biodataid) REFERENCES nasabah.biodata_nasabah(idbiodata)
ON UPDATE RESTRICT ON DELETE RESTRICT;


