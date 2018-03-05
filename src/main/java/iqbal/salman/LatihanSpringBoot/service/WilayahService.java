/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iqbal.salman.LatihanSpringBoot.service;

import iqbal.salman.LatihanSpringBoot.master.wilayah.Kecamatan;
import iqbal.salman.LatihanSpringBoot.master.wilayah.Kelurahan;
import iqbal.salman.LatihanSpringBoot.master.wilayah.KotaKabupaten;
import iqbal.salman.LatihanSpringBoot.master.wilayah.Provinsi;
import iqbal.salman.LatihanSpringBoot.repository.KecamatanRepository;
import iqbal.salman.LatihanSpringBoot.repository.KelurahanRepository;
import iqbal.salman.LatihanSpringBoot.repository.KotaKabupatenRepository;
import iqbal.salman.LatihanSpringBoot.repository.ProvinsiRepository;
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
public class WilayahService {

    @Autowired
    private KotaKabupatenRepository kotaRepository;
    @Autowired
    private ProvinsiRepository provinsiRepository;

    @Autowired
    private KecamatanRepository kecamatanRepository;

    @Autowired
    private KelurahanRepository kelurahanRepository;

    public List<Provinsi> findAllProvinsi() {
        return (List<Provinsi>)this.provinsiRepository.findAll();
    }
    @Transactional(readOnly = false)
    public List<KotaKabupaten>findAllKotaKabupaten() {
        return this.kotaRepository.findAll();
    }

    @Transactional(readOnly = false)
    public List<Kecamatan>findAllKecamatan(){
        return this.kecamatanRepository.findAll();
    }

    @Transactional(readOnly = false)
    public  List<Kelurahan>findAllKelurahan(){
        return  this.kelurahanRepository.findAll();
    }


    @Transactional(readOnly = false)
    public  Kecamatan simpan(Kecamatan x){
        return this.kecamatanRepository.save(x);
    }

    @Transactional(readOnly = false)
    public void hapus(String kodekec){
        this.kecamatanRepository.delete(kodekec);
    }

    @Transactional(readOnly = false)
    public Kelurahan saved(Kelurahan x){
        return this.kelurahanRepository.save(x);
    }

    @Transactional(readOnly = false)
    public KotaKabupaten save(KotaKabupaten x){
        return this.kotaRepository.save(x);
    }

    @Transactional(readOnly = true)
    public KotaKabupaten findById(String kode) {
        return kotaRepository.findOne(kode);
    }

    @Transactional(readOnly = true)
    public  Kelurahan findbyIdkel(String kodekel){
        return kelurahanRepository.findOne(kodekel);
    }

    @Transactional(readOnly = true)
    public Kecamatan finbyIdkec(String kodekec){
        return  kecamatanRepository.findOne(kodekec);
    }

    @Transactional(readOnly = true)
    public  Provinsi findbyid(String id){
        return  provinsiRepository.findOne(id);
    }

    @Transactional(readOnly = false)
    public Provinsi savep(Provinsi x){
        return this.provinsiRepository.save(x);
    }

    @Transactional(readOnly = false)
    public void delete(String del){
        this.kotaRepository.delete(del);
    }
    @Transactional(readOnly = false)
    public  void deletek(String idkel){
        this.kelurahanRepository.delete(idkel);
    }

    @Transactional(readOnly = false)
    public  void deletedata(String idu){
        this.provinsiRepository.delete(idu);
    }
    
    
}
