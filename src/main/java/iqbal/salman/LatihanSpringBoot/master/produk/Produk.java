/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iqbal.salman.LatihanSpringBoot.master.produk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import java.math.BigDecimal;

/**
 *
 * @author iqbal
 */
@Entity
@Table(name = "kriteria_tabungan",schema = "master")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produk {
    @Id
    @GenericGenerator(name = "produk_id", strategy = "uuid2")
    
    @GeneratedValue(generator = "produk_id")
    @Column(name = "id")
    private String id;

    @Column(name = "kode",unique = true,nullable = false,length = 50)
    private String kode;

    @Column(name = "nama", nullable = false, length = 150)
    private String nama;


    @Column(name = "suku_bunga", nullable = false,scale = 2, length = 3)
    private double bunga;


    @Column(name = "setoran_awal", nullable = false)
    private BigDecimal setoran_awal;


    @Column(name = "biaya_administrasi", nullable = false,  length = 50)
    private BigDecimal biaya_admin;

    @Column(name = "is_active",nullable = false)
    private Boolean active;
    
}
