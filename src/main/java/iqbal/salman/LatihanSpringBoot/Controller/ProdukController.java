package iqbal.salman.LatihanSpringBoot.Controller;


import iqbal.salman.LatihanSpringBoot.master.produk.Produk;
import iqbal.salman.LatihanSpringBoot.service.ProdukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/produk")
public class ProdukController {

    @Autowired
    ProdukService produkService;

    @GetMapping(value = {"/","/list"})
       public String Tampil(Produk produk, ModelMap params){
        params.addAttribute("lisproduk",produkService.findAll());
        return "/pages/Produk/list";
    }

    @GetMapping("/form")
    public  String TambahData(Produk produk, ModelMap params){
        params.addAttribute("produk",produk);
        return "/pages/Produk/form";
    }

    @PostMapping("/submit")
    public String SimpanData(@Valid @ModelAttribute Produk produk,
                             BindingResult bindingResult,RedirectAttributes riderek){
        if(bindingResult.hasErrors()){
            return "/pages/Produk/form";
        }
        produkService.save(produk);
        riderek.addFlashAttribute("sukses","Data Berhasil Disimpan");
        return  "redirect:/produk/list";
    }

    @RequestMapping("/hapus/{id}")
    public String hapusData(@PathVariable (value = "id" )String idu, RedirectAttributes rederect){
        produkService.delete(idu);
        rederect.addFlashAttribute("sukses","Data Berhasil Di hapus");
        return  "redirect:/produk/list";
    }

    @GetMapping("/form/{id}")
    public  String EditData(@PathVariable (value = "id") String idp,
                            ModelMap params,
                            RedirectAttributes ridek){
        Produk produk = this.produkService.findById(idp);
        if (produk != null){
            params.addAttribute("produk",produk);
            return "/pages/Produk/form";
        }else{
            ridek.addFlashAttribute("noValid","Data Tidak ditemukan");
            return  "redirect:/produk/list";
        }


    }
}
