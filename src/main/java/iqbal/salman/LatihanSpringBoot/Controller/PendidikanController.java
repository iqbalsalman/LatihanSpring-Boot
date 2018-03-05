package iqbal.salman.LatihanSpringBoot.Controller;

import iqbal.salman.LatihanSpringBoot.master.pendidikan.Pendidikan;
import iqbal.salman.LatihanSpringBoot.service.PendidikanService;
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
@RequestMapping("/pendidikan")
public class PendidikanController {

    @Autowired
    PendidikanService pendidik;

    @GetMapping(value = {"/","/list"})
    public String DataPendidik(Pendidikan pendidikan, ModelMap prams){
        prams.addAttribute("pendidikan",pendidik.findAll());
        return "/pages/pendidikan/list";
    }

    @GetMapping("/form")
    public String Formpendidikan(Pendidikan pendidikan,ModelMap params){
        params.addAttribute("pendidikan",pendidikan);
        return "/pages/pendidikan/form";
    }

    @PostMapping("/submit")
    public String SimpanPendidikan(@Valid @ModelAttribute Pendidikan pendidikan,
                                   BindingResult binding,
                                   RedirectAttributes ridirec){
        if(binding.hasErrors()){
          return "pages/pendidikan/form";
        }
        pendidikan.setCreatedBy("admin");
        pendidikan.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        pendidik.save(pendidikan);
        ridirec.addFlashAttribute("Sukses","Data Berhasil Disimpan");
        return "redirect:/pendidikan/list";
    }
    @RequestMapping("/hapus/{id}")
    public  String DeletePendidikan(@PathVariable (value = "id") String idu,
                                    RedirectAttributes riderek){
        pendidik.delete(idu);
        riderek.addFlashAttribute("Sukses","Data Berhasi dihapus");
        return "redirect:/pendidikan/list";
    }

    @GetMapping("/form/{id}")
    public String UpdatePendidikan(@PathVariable (value = "id") String idu
            ,ModelMap modelMap, RedirectAttributes ridek){
        Pendidikan pendidikan = pendidik.pendidikanFindbyID(idu);
        if(pendidikan != null){
            modelMap.addAttribute("pendidikan",pendidikan);
            return "pages/pendidikan/form";
        }else {
            ridek.addFlashAttribute("Novalided","Data Tidak ditemukan");
            return "redirect:/pendidikan/list";
        }
    }

}
