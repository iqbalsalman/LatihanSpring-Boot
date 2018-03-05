package iqbal.salman.LatihanSpringBoot.repository;

import iqbal.salman.LatihanSpringBoot.master.nasabah.Alamat_Rumah;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlamatRumahRepository extends CrudRepository<Alamat_Rumah,String>{
    List<Alamat_Rumah>findAll();
}
