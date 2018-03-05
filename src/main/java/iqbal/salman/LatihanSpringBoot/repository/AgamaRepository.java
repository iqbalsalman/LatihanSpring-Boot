/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package iqbal.salman.LatihanSpringBoot.repository;


import iqbal.salman.LatihanSpringBoot.master.agama.Agama;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @author iqbal
 */
public interface AgamaRepository extends CrudRepository<Agama, String> {

    public List<Agama> findAll();

    public Agama findByNama(String namaAgama);

    public List<Agama> findByNamaOrDeskripsi(String nama, String deskripsi);
    @Modifying
    @Query("update Agama set nama = ?2, deskripsi = ?3 where id = ?1")
    public int updateNamaAndDescription(String id, String nama, String description);
    
}
