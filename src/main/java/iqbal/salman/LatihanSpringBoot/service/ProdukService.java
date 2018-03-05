/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iqbal.salman.LatihanSpringBoot.service;

import iqbal.salman.LatihanSpringBoot.master.produk.Produk;
import iqbal.salman.LatihanSpringBoot.repository.ProdukRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author iqbal
 */
@Service
@Transactional(readOnly = true)
public class ProdukService {
    
    @Autowired
    private ProdukRepository repo;

    @Transactional(readOnly = false)
    public Produk save(Produk p) {
        return this.repo.save(p);
    }

    public Produk findById(String id) {
        return this.repo.findOne(id);
    }

    public List<Produk> findAll() {
        return this.repo.findAll();
    }

    public void delete(Produk p) {
        this.repo.delete(p);
    }

    @Transactional(readOnly = false)
    public void delete(String id) {
        this.repo.delete(id);
    }

    public void delete(List<Produk> list) {
        this.repo.delete(list);
    }
    
}
