package iqbal.salman.LatihanSpringBoot.service;


import iqbal.salman.LatihanSpringBoot.master.Tabungan.Tabungan;
import iqbal.salman.LatihanSpringBoot.master.produk.Produk;
import iqbal.salman.LatihanSpringBoot.master.transaksi.MutasiTabungan;
import iqbal.salman.LatihanSpringBoot.repository.AplikasiTabunganRepository;
import iqbal.salman.LatihanSpringBoot.repository.MutasiTabunganRepository;
import iqbal.salman.LatihanSpringBoot.repository.ProdukRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class TabunganService {

    @Autowired
    private AplikasiTabunganRepository tabunganRepository;

    @Autowired
    private ProdukRepository produkRepository;

    @Autowired
    private MutasiTabunganRepository mutasiTabunganRepository;

    @Transactional(readOnly = false)
    public Tabungan findByid(String id){
        return this.tabunganRepository.findOne(id);
    }

    @Transactional
    public List<Tabungan>findAll(){
        return this.tabunganRepository.findAll();
    }

    @Transactional
    public List<Produk>findAllkriteriaProduk(){
        return this.produkRepository.findAll();
    }

    @Transactional
    public Tabungan save(MutasiTabungan mutasi){
        Tabungan tabungan = mutasi.getTabungan();
        tabungan = this.tabunganRepository.save(tabungan);
        mutasi.setTabungan(tabungan);
        this.mutasiTabunganRepository.save(mutasi);
        this.tabunganRepository.updateSaldoTabungan(mutasi.getCredit(),tabungan.getId());
        return tabungan;
    }

    @Transactional
    public  MutasiTabungan setoran(MutasiTabungan mutasi){
        this.mutasiTabunganRepository.save(mutasi);
        this.tabunganRepository.updateSaldoTabungan(mutasi.getCredit(),mutasi.getTabungan().getId());
        return  mutasi;
    }

    @Transactional
    public  MutasiTabungan tarik(MutasiTabungan mutasi){
        this.mutasiTabunganRepository.save(mutasi);
        this.tabunganRepository.updateSaldoTabunganTarik(mutasi.getDebet(),mutasi.getTabungan().getId());
        return mutasi;
    }

}
