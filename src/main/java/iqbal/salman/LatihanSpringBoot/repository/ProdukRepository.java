/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iqbal.salman.LatihanSpringBoot.repository;

import iqbal.salman.LatihanSpringBoot.master.produk.Produk;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author iqbal
 */
public interface ProdukRepository extends CrudRepository<Produk, String>{
    
    public List<Produk> findAll(); 
}
