package iqbal.salman.LatihanSpringBoot.master.nasabah;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Data
@Table(name = "biodata_nasabah",schema = "nasabah")
@AllArgsConstructor
@NoArgsConstructor
public class Biodata {

    @Id
    @GenericGenerator(name = "biodata_uuid", strategy = "uuid2")
    @GeneratedValue(generator = "biodata_uuid")
    @Column(name = "idbiodata",nullable = false,length = 50)
    private String id;

    @Column(name ="tanda_pengenal" ,nullable = false,length = 50)
    private String tanda_pengenal;

    @Column(name = "no_pengenal",length = 50)
    private String no_pengenal;

    @Column(name = "berlaku_s_d")
    private Date tanggal_berlaku;

    @Column(name = "tempatlahir",length = 50)
    private String tempatlahir;

    @Column(name = "tanggallahir")
    private Date tanggallahir;

    @Column(name = "status_perkawinan",length = 20)
    private String status;


//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//    @JoinColumn(name = "idbiodata")
//    private Alamat_Rumah rumah;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "idnasabah")
    private NasabahPerorangan nasabah;


}
