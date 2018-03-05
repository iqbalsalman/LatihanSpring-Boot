package iqbal.salman.LatihanSpringBoot.Controller;


import iqbal.salman.LatihanSpringBoot.master.wilayah.Kecamatan;
import iqbal.salman.LatihanSpringBoot.service.WilayahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RequestMapping("/kecamatan")
@Controller
public class KecamatanController {

    @Autowired
    WilayahService wilayahService;

    @RequestMapping(value = {"/","/list"})
    public String Tampilkecamatan(Kecamatan kecamatan, ModelMap params){
        params.addAttribute("kecamatan",wilayahService.findAllKecamatan());
        return "/pages/kecamatan/list";
    }

    @GetMapping("/form")
    public  String Forminput(Kecamatan kec,ModelMap paramas){
        paramas.addAttribute("kec", kec);
        paramas.addAttribute("listkecamatan",wilayahService.findAllKotaKabupaten());
        return "/pages/kecamatan/formkec";
    }

    @PostMapping("/submit")
    public String simpanData(@Valid @ModelAttribute Kecamatan kec,
                             BindingResult bindingResult,ModelMap params
            , RedirectAttributes redirectAttr){
        if (bindingResult.hasErrors()){
            params.addAttribute("listkecamatan",wilayahService.findAllKotaKabupaten());
            return "/pages/kecamatan/formkec";
        }
        kec.setCreatedBy("Indonesia");
        wilayahService.simpan(kec);
        redirectAttr.addFlashAttribute("Sukses","Data Berhasil disimpan");
        return "redirect:/kecamatan/list";
    }

    @RequestMapping("/hapus/{id}")
    public String hapusData(@PathVariable (value = "id") String idup,
                            RedirectAttributes redirectAttr){
    wilayahService.hapus(idup);
    redirectAttr.addFlashAttribute("Sukses","Data Berhasil di hapus");
        return "redirect:/kecamatan/list";
    }

    @GetMapping("/form/{id}")
    public String updateData(@PathVariable (value = "id") String idu,
                             ModelMap params,
                             RedirectAttributes redirectAttr){
        Kecamatan kec = this.wilayahService.finbyIdkec(idu);
        params.addAttribute("listkecamatan",wilayahService.findAllKotaKabupaten());
        if (kec != null) {
            params.addAttribute("kec", kec);
            return "/pages/kecamatan/formkec";
        } else {
            redirectAttr.addFlashAttribute("NotAvalibel", "Data Yang dicari tidak ada");
        }
        return "redirect:/kecamatan/list";

    }
}
