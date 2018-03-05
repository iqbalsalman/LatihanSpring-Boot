package iqbal.salman.LatihanSpringBoot.master.wilayah;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "master_provinsi",schema = "wilayah")
@ToString(exclude = "kota")
public class  Provinsi {
    @Id
    @GenericGenerator(name = "uuid_provinsi", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_provinsi")
    @Column(name = "kode_provinsi", nullable = false, unique = true)
    private String id;

    @NotEmpty(message = "Data Tidak Boleh Kosong")
    @Column(name = "nama_provinsi", nullable = false, length = 50)
    private String nama;

    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;

    @Column(name = "created_by", length = 20)
    private String createBy;

    @OneToMany(mappedBy = "kota")
    private List<KotaKabupaten> kota = new ArrayList<>();
}
