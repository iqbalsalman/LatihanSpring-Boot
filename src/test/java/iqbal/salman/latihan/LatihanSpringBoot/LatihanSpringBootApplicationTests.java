package iqbal.salman.latihan.LatihanSpringBoot;

import iqbal.salman.LatihanSpringBoot.LatihanSpringBootApplication;
import iqbal.salman.LatihanSpringBoot.master.wilayah.Kecamatan;
import iqbal.salman.LatihanSpringBoot.master.wilayah.Kelurahan;

import iqbal.salman.LatihanSpringBoot.master.produk.Produk;
import iqbal.salman.LatihanSpringBoot.service.ProdukService;
import iqbal.salman.LatihanSpringBoot.service.WilayahService;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = LatihanSpringBootApplication.class)
public class LatihanSpringBootApplicationTests extends TestCase {
    
    @Autowired
    private ProdukService produkService;
    
    @Autowired
    private WilayahService wilayahService;
    
    @Test
    public void testProduk() {
        
        Produk produk = new Produk();
        produk.setNama("Nabati Kismis");
        produk.setSetoran("10000");
        produk.setBunga("10%");
        produk.setBiaya("100000");
        produk.setMin_saldo("40000");
        produk.setBiaya_penutup("1000000");
        produk = this.produkService.save(produk);
        assertNotNull(produk.getId());
        
    }
    
    @Test
    public void simpanWilayah(){
        Kecamatan kecamatan = new Kecamatan();
        kecamatan.setNama("BojongSoang");
        kecamatan.setPos("4033");
        kecamatan.setCreatedBy("Muhamad Iqbal Salman");
        kecamatan = this.wilayahService.simpan(kecamatan);
        assertNotNull(kecamatan.getId());
        
        
        Kelurahan kel = new Kelurahan();
        kel.setNama_kel("Bojong");
        kel.setPos_kel("748343");
        kel.setKecamatan(kecamatan);
        kel = this.wilayahService.saved(kel);
        assertNotNull(kel.getId());

        Kelurahan islam = new Kelurahan();
        islam.setNama_kel("Bojong Kidul");
        islam.setPos_kel("405758");
        islam.setKecamatan(kecamatan);
        islam = this.wilayahService.saved(islam);
        assertNotNull(islam.getId());
    }

}
