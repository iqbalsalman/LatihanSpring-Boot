package iqbal.salman.LatihanSpringBoot.Controller;


import iqbal.salman.LatihanSpringBoot.master.agama.Agama;
import iqbal.salman.LatihanSpringBoot.master.nasabah.Alamat_Rumah;
import iqbal.salman.LatihanSpringBoot.master.nasabah.Biodata;
import iqbal.salman.LatihanSpringBoot.master.nasabah.NasabahPerorangan;
import iqbal.salman.LatihanSpringBoot.service.AgamaService;
import iqbal.salman.LatihanSpringBoot.service.AlmataRumahService;
import iqbal.salman.LatihanSpringBoot.service.BiodataService;
import iqbal.salman.LatihanSpringBoot.service.NasabahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Controller
@RequestMapping("/biodata")
public class BiodataController {

    @Autowired
    BiodataService biodataService;

    @Autowired
    AlmataRumahService rumahService;

    @Autowired
    NasabahService nasabahService;

    @Autowired
    AgamaService agamaService;

    @GetMapping(value = {"/", "/nasabah"})
    public String DataBiodata(ModelMap paramas){
        paramas.addAttribute("listbiodata",biodataService.findAll());
        return "/pages/Nasabah/biodata";
    }
    @GetMapping("/form")
    public String formBiodata(ModelMap params){
        Alamat_Rumah rumah = new Alamat_Rumah();
        Biodata biodata = new Biodata();
        NasabahPerorangan nasabah = new NasabahPerorangan();
        Agama agama = new Agama();
        params.addAttribute("nasabah",nasabah);
        params.addAttribute("biodata",biodata);
        params.addAttribute("rumah",rumah);
        params.addAttribute("agama",agamaService.findAll());
        return "/pages/Nasabah/formbiodata";
    }
    @PostMapping("/submit")
    public String Submitdata(@Valid @ModelAttribute("nasabah") NasabahPerorangan nasabah,
                             @ModelAttribute("biodata") Biodata biodata,
                             @ModelAttribute("rumah") Alamat_Rumah rumah,
                             BindingResult bindingResult, RedirectAttributes
                             riderek,HttpServletRequest request){

        if(bindingResult.hasErrors()){
           return "/pages/nasabah/formbiodata";
        }
        biodata.setNasabah(nasabah);
        rumah.setBiodata(biodata);
        biodata.setTanggallahir(Date.valueOf(LocalDate.now()));
        biodata.setTanggal_berlaku(Date.valueOf(LocalDate.now()));
//        biodataService.save(biodata);
        rumahService.save(rumah);
        riderek.addFlashAttribute("Sukses","Data Berhasil Disimpan");
          return  "redirect:/nasabah/list";
    }

}
