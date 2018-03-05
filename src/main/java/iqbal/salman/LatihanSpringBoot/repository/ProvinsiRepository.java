package iqbal.salman.LatihanSpringBoot.repository;

import iqbal.salman.LatihanSpringBoot.master.wilayah.Provinsi;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProvinsiRepository extends CrudRepository<Provinsi, String> {
    public List<Provinsi> findAll();

}