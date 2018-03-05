package iqbal.salman.LatihanSpringBoot.repository;

import iqbal.salman.LatihanSpringBoot.master.transaksi.MutasiTabungan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MutasiTabunganRepository extends CrudRepository<MutasiTabungan,String>
{
    List<MutasiTabungan>findAll();
}
