/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  iqbal
 * Created: Feb 12, 2018
 */

    CREATE TABLE produk (
        id_produk CHARACTER VARYING(255) NOT NULL PRIMARY KEY,
        nama_produk CHARACTER VARYING(50) not null UNIQUE,
        setoran_produk CHARACTER VARYING(50),
        bunga CHARACTER VARYING(50),
        biaya_admin CHARACTER VARYING(50) not null,
        min_saldo CHARACTER VARYING(50) not null,
        biaya_penutup CHARACTER VARYING(50) not null
  );

  insert into produk values('ahsa78ajssna78','mecin','50000','10%','5000','10000','8000');