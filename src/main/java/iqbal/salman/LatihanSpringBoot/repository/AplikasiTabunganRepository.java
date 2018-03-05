package iqbal.salman.LatihanSpringBoot.repository;

import iqbal.salman.LatihanSpringBoot.master.Tabungan.Tabungan;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface AplikasiTabunganRepository extends CrudRepository<Tabungan,String> {

    List<Tabungan> findAll();

    @Modifying
    @Query("update Tabungan tab set tab.saldo = (tab.saldo + ?1) where tab.id = ?2")
    int updateSaldoTabungan(BigDecimal saldo, String idTabungan);

    @Modifying
    @Query("update Tabungan tab set tab.saldo = (tab.saldo - ?1) where tab.id = ?2")
    int updateSaldoTabunganTarik(BigDecimal saldo,String idTabungan);
}
