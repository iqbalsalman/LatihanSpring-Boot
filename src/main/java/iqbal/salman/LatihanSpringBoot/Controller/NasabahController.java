package iqbal.salman.LatihanSpringBoot.Controller;



import iqbal.salman.LatihanSpringBoot.master.nasabah.Nasabah;
import iqbal.salman.LatihanSpringBoot.master.nasabah.NasabahPerorangan;
import iqbal.salman.LatihanSpringBoot.service.NasabahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/nasabah")
public class NasabahController {

    @Autowired
    NasabahService nasabahService;

    @GetMapping(value = {"/","/list"})
    public  String AllNasabah(Nasabah nasabah,
                              NasabahPerorangan nasap, ModelMap params){
        params.addAttribute("listnasabah",nasabahService.findAllNasabahPerorangan());
        return "/pages/Nasabah/list";
    }

    @GetMapping("/form")
    public  String FormNasabah(NasabahPerorangan nasabah,ModelMap params){
        params.addAttribute("nasabah",nasabah);
        return  "/pages/Nasabah/formnasabah";
    }

    @PostMapping("/submit")
    public String simpanData(@Valid @ModelAttribute NasabahPerorangan nasabah,
                             BindingResult bindingResult, ModelMap params
            , RedirectAttributes redirectAttr){
        if (bindingResult.hasErrors()){

            return  "/pages/Nasabah/formnasabah";

        }
        nasabahService.save(nasabah);
        redirectAttr.addFlashAttribute("Sukses","Data Berhasil disimpan");
        return "redirect:/nasabah/list";
    }

    @RequestMapping("/form/{id}")
    public String updateData(@PathVariable (value = "id")String idup,
                             ModelMap params,RedirectAttributes ridek){
        NasabahPerorangan nasabah = this.nasabahService.findById(idup);
        if (nasabah != null) {
            params.addAttribute("nasabah", nasabah);
            return  "/pages/Nasabah/formnasabah";
        } else {
            ridek.addFlashAttribute("NotAvalibel", "Data Yang dicari tidak ada");
        }
        return "redirect:/nasabah/list";
    }

    @RequestMapping("/hapus/{id}")
    public String hapusData(@PathVariable(value = "id") String idup,
                            RedirectAttributes redirectAttr){
        nasabahService.delete(idup);
        redirectAttr.addFlashAttribute("Sukses","Data Berhasil di hapus");
        return "redirect:/nasabah/list";
    }
}
