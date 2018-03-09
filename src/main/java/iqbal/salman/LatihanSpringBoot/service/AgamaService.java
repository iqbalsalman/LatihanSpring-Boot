/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iqbal.salman.LatihanSpringBoot.service;


import iqbal.salman.LatihanSpringBoot.master.agama.Agama;
import iqbal.salman.LatihanSpringBoot.repository.AgamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author iqbal
 */
@Service
@Transactional(readOnly = true)
public class AgamaService {

    @Autowired
    private AgamaRepository repo;

    @Transactional(readOnly = false)
    public Agama save(Agama x) {
        return repo.save(x);
    }

    public Agama findById(String kode) {
        return repo.findOne(kode);
    }

    public List<Agama> findAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = false)
    public void delete(Agama x) {
        this.repo.delete(x);
    }

    @Transactional(readOnly = false)
    public void delete(String x) {
        this.repo.delete(x);
    }

    @Transactional(readOnly = false)
    public void delete(List<Agama> list) {
        this.repo.delete(list);
    }

    public Agama findByNama(String nama) {
        return this.repo.findByNama(nama);
    }

    public List<Agama> mencariBerdasarkanNamaAtauDeskripsi(String input) {
        return this.repo.findByNamaOrDeskripsi(input, input);
    }

    @Transactional(readOnly = false)
    public void updateById(String id, String nama, String description) {
        this.repo.updateNamaAndDescription(id,nama, description);
    }

}
