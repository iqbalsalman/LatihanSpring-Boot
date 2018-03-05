/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iqbal.salman.LatihanSpringBoot.master.wilayah;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author iqbal
 */
@Entity
@Table(name = "kelurahan_bandung",schema = "wilayah")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kelurahan {
    
    @Id
    @GenericGenerator(name = "idkel", strategy = "uuid2")
    
    @GeneratedValue(generator = "idkel")
    @Column(name = "id_kelurahan")
    private String id;
    
    @Column(name = "nama_kelurahan", nullable = false, length = 50)
    private String nama_kel;
    
    @Column(name = "kode_pos_kel", nullable = false, length = 50)
    private String pos_kel;
    
    @ManyToOne
    @JoinColumn(name = "kecamatan_id ", nullable = false)
    private Kecamatan kecamatan;
    
}
