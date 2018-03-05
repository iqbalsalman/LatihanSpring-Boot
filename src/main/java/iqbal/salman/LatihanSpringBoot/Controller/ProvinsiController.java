package iqbal.salman.LatihanSpringBoot.Controller;


import iqbal.salman.LatihanSpringBoot.master.wilayah.Provinsi;
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
@RequestMapping("/provinsi")
public class ProvinsiController {

    @Autowired
    WilayahService wilayahService;

    @GetMapping(value = {"/", "/list"})
    public  String FormTampil(ModelMap params){
        params.addAttribute("provinsi",wilayahService.findAllProvinsi());
        return "/pages/provinsi/list";

    }

    @GetMapping("/form")
    public String formAgama(Provinsi provinsi, ModelMap params) {
        params.addAttribute("provinsi", provinsi);
        return "/pages/provinsi/formprovinsi";
    }
    @PostMapping("/submit")
    public  String SubmitKota(@Valid @ModelAttribute Provinsi provinsi, BindingResult bindingResult, ModelMap params,
                              RedirectAttributes redirect){
        if(bindingResult.hasErrors()){
            return "pages/provinsi/formprovinsi";

        }
        provinsi.setCreateBy("Indonesia");
        provinsi.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        wilayahService.savep(provinsi);
        redirect.addFlashAttribute("sukses","Data Berhasil Disimpan");
        return  "redirect:/provinsi/list";
    }

    @RequestMapping("hapus/{id}")
    public String hapuData (@PathVariable (value = "id") String idup,
                            RedirectAttributes redirect){

        wilayahService.deletedata(idup);
        redirect.addFlashAttribute("sukses","Data Berhasil dihapus");
        return  "redirect:/provinsi/list";
    }

    @RequestMapping("form/{id}")
    public  String Updatedata(@PathVariable (value = "id") String idi,
                              ModelMap params,
                              RedirectAttributes rederect){
        Provinsi provinsi = wilayahService.findbyid(idi);
        if (provinsi != null) {
            params.addAttribute("provinsi", provinsi);
            return "pages/provinsi/formprovinsi";
        } else {
            rederect.addFlashAttribute("NotAvalibel", "Data Yang dicari tidak ada");
        }
        return  "redirect:/provinsi/list";

    }
}
