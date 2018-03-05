package iqbal.salman.LatihanSpringBoot.repository;

import iqbal.salman.LatihanSpringBoot.master.nasabah.Biodata;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BiodataRepository extends CrudRepository<Biodata,String>{
    List<Biodata>findAll();
}
