/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iqbal.salman.LatihanSpringBoot.repository;

import iqbal.salman.LatihanSpringBoot.master.wilayah.Kelurahan;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author iqbal
 */
public interface KelurahanRepository extends CrudRepository<Kelurahan, String>{
    List<Kelurahan>findAll();
}
