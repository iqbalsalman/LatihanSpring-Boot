
CREATE TABLE nasabah.data_nasabah (
  tipe_nasabah    CHARACTER VARYING(50),
  nasabah_id      CHARACTER VARYING(64) NOT NULL PRIMARY KEY,
  nama_lengkap    CHARACTER VARYING(50) NOT NULL,
  alamat_identitas  TEXT,
  nomor_npwp      CHARACTER VARYING(62),
  nomor_identitas CHARACTER VARYING(64),
  jenis_kelamin   CHARACTER VARYING(1)
 );