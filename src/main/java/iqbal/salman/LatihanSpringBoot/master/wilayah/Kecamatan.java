/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iqbal.salman.LatihanSpringBoot.master.wilayah;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author iqbal
 */

@Entity
@Table(name = "kecamatan_bandung",schema = "wilayah")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "kecamatan")
public class Kecamatan {

    @Id
    @GenericGenerator(name = "idkec", strategy = "uuid2")

    @GeneratedValue(generator = "idkec")
    @Column(name = "id_kecamatan")
    private String id;

    @Column(name = "nama_kecamatan", nullable = false, length = 50)
    private String nama;

    @Column(name = "kode_pos", nullable = false, length = 50)
    private String pos;

    @Column(name = "created_by", length = 50)
    private String createdBy;

    @NotNull(message = "belum dipilih!")
    @ManyToOne
    @JoinColumn(name = "kabupaten_id", nullable = false)
    private KotaKabupaten kec;

    @OneToMany(mappedBy = "kecamatan")
    private List<Kelurahan> kecamatan = new ArrayList<>();
    
}
