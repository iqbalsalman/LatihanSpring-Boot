
DROP  TABLE produk;
----------------------------------------------
----------------------------------------------
ALTER TABLE aplikasi.tabungan
  RENAME COLUMN nomor_register TO nomor_rekening;
----------------------------------------------
CREATE SCHEMA transaksi;
CREATE TABLE transaksi.mutasi_tabungan (
  id                CHARACTER VARYING(64) NOT NULL UNIQUE  PRIMARY KEY,
  tabungan_id       CHARACTER VARYING(64) NOT NULL,
  debet             NUMERIC               NOT NULL DEFAULT 0,
  credit            NUMERIC               NOT NULL DEFAULT 0,
  saldo             NUMERIC               NOT NULL DEFAULT 0,
  tanggal_transaksi DATE                  NOT NULL DEFAULT now(),
  keterangan        TEXT,
  created_date      TIMESTAMP             NOT NULL DEFAULT now(),
  created_by        CHARACTER VARYING(20)
)