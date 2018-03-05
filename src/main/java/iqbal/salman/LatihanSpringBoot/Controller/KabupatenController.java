package iqbal.salman.LatihanSpringBoot.Controller;

import iqbal.salman.LatihanSpringBoot.master.wilayah.KotaKabupaten;
import iqbal.salman.LatihanSpringBoot.service.WilayahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/kab")
public class KabupatenController {


    @Autowired
    WilayahService wilayahService;

    @GetMapping(value = {"/", "/list"})
    public String lisAgama(ModelMap params) {
        params.addAttribute("liskota", wilayahService.findAllKotaKabupaten());
        return "/pages/kota/list";
    }

    @GetMapping("/form")
    public  String formKabupaten(KotaKabupaten kotaKabupaten, ModelMap params){
        params.addAttribute("kotaKabupaten", kotaKabupaten);
        params.addAttribute("listProvinsi", wilayahService.findAllProvinsi());
        return "/pages/kota/form";
    }

    @PostMapping("/submit")
    public  String SubmitKota(@Valid @ModelAttribute KotaKabupaten kotaKabupaten, BindingResult bindingResult, ModelMap params,
                              RedirectAttributes redirect){
        if(bindingResult.hasErrors()){
            params.addAttribute("listProvinsi",wilayahService.findAllProvinsi());
            return "pages/kota/form";

        }
        kotaKabupaten.setCreateBy("iqbal");
        kotaKabupaten.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        wilayahService.save(kotaKabupaten);
        redirect.addFlashAttribute("Sukses","Data Berhasil Disimpan");
        return  "redirect:/kab/list";
    }
    @RequestMapping("/hapus/{id}")
    public String hapusData(@PathVariable (value = "id" )String idu, RedirectAttributes rederect){
        wilayahService.delete(idu);
        rederect.addFlashAttribute("alertSuccess","Data Berhasil Di hapus");
        return  "redirect:/kab/list";
    }

    @GetMapping("/form/{id}")
    public  String FormEdit(@PathVariable (value = "id") String idu, ModelMap params,
                            RedirectAttributes rederect){
       KotaKabupaten kotaKabupaten = this.wilayahService.findById(idu);
        params.addAttribute("listProvinsi", wilayahService.findAllProvinsi());
        if (kotaKabupaten != null) {
            params.addAttribute("kotaKabupaten", kotaKabupaten);
            return "/pages/kota/form";
        } else {
            rederect.addFlashAttribute("NotAvalibel", "Data Yang dicari tidak ada");
        }
        return "redirect:/kab/list";


    }


}
