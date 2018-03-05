/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iqbal.salman.LatihanSpringBoot.repository;


import iqbal.salman.LatihanSpringBoot.master.nasabah.NasabahPerorangan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @author iqbal
 */
public interface NasabahPeroranganRepository extends CrudRepository<NasabahPerorangan, String> {

    public List<NasabahPerorangan> findAll();
}
