package iqbal.salman.LatihanSpringBoot.master.nasabah;

import iqbal.salman.LatihanSpringBoot.master.agama.Agama;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Data
@Table(name = "alamat_rumah",schema = "nasabah")
@AllArgsConstructor
@NoArgsConstructor
public class Alamat_Rumah {
    @Id
    @GenericGenerator(name = "uuid_alamat",strategy = "uuid2")
    @GeneratedValue(generator = "uuid_alamat")
    @Column(name = "idalamat",nullable = false,length = 50)
    private String idalamat;

    @Column(name = "kota",nullable = false,length = 50)
    private String kota;

    @Column(name = "kodepos",nullable = false,length = 10)
    private String kodepos;

    @Column(name = "no_tlp",nullable = false,length = 20)
    private String tlp;

    @Column(name = "no_fax",length = 25)
    private String fax;

    @Column(name = "no_hp",length = 30)
    private String nohp;

    @Column(name = "email",length = 50)
    private String email;

    @Column(name = "agama",nullable = false,length = 225)
    private String agamaid;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "biodataid")
    private Biodata biodata;







}
