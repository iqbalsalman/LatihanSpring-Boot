package iqbal.salman.LatihanSpringBoot.repository;

import iqbal.salman.LatihanSpringBoot.master.pendidikan.Pendidikan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PendidikanRepository extends CrudRepository<Pendidikan,String>{
    List<Pendidikan>findAll();
}
