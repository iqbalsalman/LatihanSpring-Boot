package iqbal.salman.LatihanSpringBoot.Controller;


import iqbal.salman.LatihanSpringBoot.master.nasabah.NasabahBadanUsaha;
import iqbal.salman.LatihanSpringBoot.service.NasabahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/nasabahbadan")
public class NabahBController {
    @Autowired
    NasabahService nasabahService;

    @GetMapping(value = {"/","/list"})
    public  String AllNasabahbadan(NasabahBadanUsaha nasabahb,
                                    ModelMap params){
        params.addAttribute("listnasabah",nasabahService.findAllNasabahBadan());
        return "/pages/NasabahBadan/list";
    }

    @GetMapping("/form")
    public  String FormNasabah(NasabahBadanUsaha nasabahb,ModelMap params){
        params.addAttribute("nasabahb",nasabahb);
        return  "/pages/NasabahBadan/formnasabah";
    }

    @PostMapping("/submit")
    public String simpanData(@Valid @ModelAttribute NasabahBadanUsaha nasabahb,
                             BindingResult bindingResult, ModelMap params
            , RedirectAttributes redirectAttr){
        if (bindingResult.hasErrors()){

            return  "/pages/NasabahBadan/formnasabah";

        }
        nasabahService.save(nasabahb);
        redirectAttr.addFlashAttribute("Sukses","Data Berhasil disimpan");
        return "redirect:/nasabahbadan/list";
    }

    @RequestMapping("/form/{id}")
    public String updateData(@PathVariable (value = "id") String idup,
                             ModelMap params,RedirectAttributes ridek){
        NasabahBadanUsaha nasabahb = this.nasabahService.findBadanUsahaById(idup);
        if (nasabahb != null) {
            params.addAttribute("nasabahb", nasabahb);
            return  "/pages/NasabahBadan/formnasabah";
        } else {
            ridek.addFlashAttribute("Novalid", "Data Yang dicari tidak ada");
        }
        return "redirect:/nasabahbadan/list";
    }

    @RequestMapping("/hapus/{id}")
    public String hapusData(@PathVariable(value = "id") String idup,
                            RedirectAttributes redirectAttr){
        nasabahService.delete(idup);
        redirectAttr.addFlashAttribute("Sukses","Data Berhasil di hapus");
        return "redirect:/nasabahbadan/list";
    }
}
