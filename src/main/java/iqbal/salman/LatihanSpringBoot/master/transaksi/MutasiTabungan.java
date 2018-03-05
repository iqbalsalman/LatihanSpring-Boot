package iqbal.salman.LatihanSpringBoot.master.transaksi;


import iqbal.salman.LatihanSpringBoot.master.Tabungan.Tabungan;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "mutasi_tabungan",schema = "transaksi")
@Data
public class MutasiTabungan {
    @Id
    @GenericGenerator(name = "uuidmut",strategy = "uuid2")
    @GeneratedValue(generator = "uuidmut")
    @Column(name = "id",unique = true,nullable = false,length = 64)
    private String id;

    @NotNull(message = "Tabungan Masih belum dipilih")
    @ManyToOne
    @JoinColumn(name = "tabungan_id",nullable = false)
    private Tabungan tabungan;

    @Column(name = "debet", nullable = false)
    private BigDecimal debet;

    @Column(name = "credit", nullable = false)
    private BigDecimal credit;

    @Column(name = "saldo", nullable = false)
    private BigDecimal saldo;

    @Column(name = "tanggal_transaksi", nullable = false)
    private Date tanggal;

    @Column(name = "keterangan")
    private String keterangan;

    @Column(name = "created_date", nullable = false)
    private Timestamp createdDate;

    @Column(name = "created_by")
    private String createdBy;
}
