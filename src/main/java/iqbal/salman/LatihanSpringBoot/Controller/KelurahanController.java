package iqbal.salman.LatihanSpringBoot.Controller;

import iqbal.salman.LatihanSpringBoot.master.wilayah.Kelurahan;
import iqbal.salman.LatihanSpringBoot.service.WilayahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/kelurahan")
public class KelurahanController {

    @Autowired
    WilayahService wilayahService;

    @RequestMapping(value = {"/","list"})
    public  String TampilData(Kelurahan kel, ModelMap params){
        params.addAttribute("listkel",wilayahService.findAllKelurahan());
        return "/pages/kelurahan/list";
    }
    @GetMapping("/form")
    public  String Forminput(Kelurahan kel,ModelMap paramas){
        paramas.addAttribute("kel", kel);
        paramas.addAttribute("listkelurahan",wilayahService.findAllKecamatan());
        return "/pages/kelurahan/formkel";
    }

    @PostMapping("/submit")
    public String simpanData(@Valid @ModelAttribute Kelurahan kel,
                             BindingResult bindingResult, ModelMap params
            , RedirectAttributes redirectAttr){
        if (bindingResult.hasErrors()){
            params.addAttribute("listkelurahan",wilayahService.findAllKecamatan());
            return "/pages/kelurahan/formkel";

        }
        wilayahService.saved(kel);
        redirectAttr.addFlashAttribute("Sukses","Data Berhasil disimpan");
        return "redirect:/kelurahan/list";
    }
    @RequestMapping("/hapus/{id}")
    public String hapusData(@PathVariable(value = "id") String idup,
                            RedirectAttributes redirectAttr){
        wilayahService.deletek(idup);
        redirectAttr.addFlashAttribute("Sukses","Data Berhasil di hapus");
        return "redirect:/kelurahan/list";
    }
    @GetMapping("/form/{id}")
    public String updateData(@PathVariable (value = "id") String idu,
                             ModelMap params,
                             RedirectAttributes redirectAttr){
        Kelurahan kel = this.wilayahService.findbyIdkel(idu);
        params.addAttribute("listkelurahan",wilayahService.findAllKecamatan());
        if (kel != null) {
            params.addAttribute("kel", kel);
            return "/pages/kelurahan/formkel";
        } else {
            redirectAttr.addFlashAttribute("NotAvalibel", "Data Yang dicari tidak ada");
        }
        return "redirect:/kelurahan/list";

    }

}

