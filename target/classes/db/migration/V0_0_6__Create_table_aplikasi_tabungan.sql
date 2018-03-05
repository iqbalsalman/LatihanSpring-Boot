CREATE SCHEMA aplikasi;
CREATE TABLE aplikasi.tabungan (
  id              CHARACTER VARYING(64) NOT NULL PRIMARY KEY,
  nomor_register  CHARACTER VARYING(15) NOT NULL,
  nasabah_id      CHARACTER VARYING(64) NOT NULL,
  tanggal_opening DATE                  NOT NULL,
  saldo           NUMERIC               NOT NULL DEFAULT 0,
  kriteria_id     CHARACTER VARYING(64) NOT NULL,
  created_date    TIMESTAMP             NOT NULL,
  created_by      CHARACTER VARYING(20)
);
ALTER TABLE aplikasi.tabungan
  ADD CONSTRAINT fk_tabungan_kriteria FOREIGN KEY (kriteria_id)
REFERENCES master.kriteria_tabungan (id)
ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE aplikasi.tabungan
  ADD CONSTRAINT fk_tabungan_nasabah FOREIGN KEY (nasabah_id)
REFERENCES nasabah.data_nasabah (nasabah_id)
ON UPDATE RESTRICT ON DELETE RESTRICT;