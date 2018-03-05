package iqbal.salman.LatihanSpringBoot.Controller;

import iqbal.salman.LatihanSpringBoot.master.Tabungan.Tabungan;
import iqbal.salman.LatihanSpringBoot.master.transaksi.MutasiTabungan;
import iqbal.salman.LatihanSpringBoot.service.NasabahService;
import iqbal.salman.LatihanSpringBoot.service.TabunganService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/tabungan")
public class TabunganController {

    private final static Logger console = LoggerFactory.getLogger(TabunganController.class);

    @Autowired
    TabunganService tabunganService;

    @Autowired
    NasabahService nasabahService;

    @GetMapping(value = {"/","list"})
    public String TampilTabungan(ModelMap params){
        params.addAttribute("listTabungan",tabunganService.findAll());
        return "/pages/tabungan/list";
    }

    @GetMapping("/form")
    public String FormData(@ModelAttribute Tabungan tabungan,
                           ModelMap params){
        params.addAttribute("tabungan",tabungan);
        params.addAttribute("listNasabah",nasabahService.findAll());
        params.addAttribute("listProduk",tabunganService.findAllkriteriaProduk());
        return "pages/tabungan/form";

    }

    @PostMapping("/submit")
    public String submitTabungan(
            @Valid @ModelAttribute Tabungan tabungan, BindingResult bindingResult,
            RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest, ModelMap params) {
        String saldoAwalText = httpServletRequest.getParameter("setoranAwal");
        BigDecimal saldoAwal = saldoAwalText != null && !saldoAwalText.isEmpty() ?
                new BigDecimal(httpServletRequest.getParameter("setoranAwal")) :
                BigDecimal.ZERO;

        tabungan.setCreatedBy("admin");
        tabungan.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        tabungan.setOpening(Date.valueOf(LocalDate.now()));
        tabungan.setSaldo(BigDecimal.ZERO);
        MutasiTabungan setoranAwal = new MutasiTabungan();
        setoranAwal.setCreatedBy(tabungan.getCreatedBy());
        setoranAwal.setCreatedDate(tabungan.getCreatedDate());
        setoranAwal.setTanggal(tabungan.getOpening());

        setoranAwal.setCredit(saldoAwal);
        setoranAwal.setDebet(BigDecimal.ZERO);
        setoranAwal.setSaldo(setoranAwal.getCredit());
        setoranAwal.setKeterangan("SETORAN_TABUNGAN");
        setoranAwal.setTabungan(tabungan);

        if (bindingResult.hasErrors()) {
            params.addAttribute("listNasabah", nasabahService.findAll());
            params.addAttribute("listProduct", tabunganService.findAllkriteriaProduk());
            return "pages/tabungan/form";
        }

        this.tabunganService.save(setoranAwal);
        redirectAttributes.addFlashAttribute("Sukses","Data Tabungan Nasabah berhasil ditambahkan");
        return "redirect:/tabungan/list";
    }
    @GetMapping("/detail/{id}")
    public String detailTabungan(@PathVariable String id, ModelMap params) {
        Tabungan tabungan = this.tabunganService.findByid(id);
        if (tabungan != null) {
            params.addAttribute("tabungan", tabungan);
            params.addAttribute("nasabah", tabungan.getNasabah());
            return "/pages/tabungan/detail_tabungan";
        } else {
            return "redirect:/tabungan/list";
        }
    }

    @GetMapping("setoran/{id}")
    public String SetoranForm(@ModelAttribute MutasiTabungan mutasiTabungan,
                              @PathVariable (value = "id") String idTabungan,
                              ModelMap params){
       Tabungan  tabungan = this.tabunganService.findByid(idTabungan);
       mutasiTabungan.setTabungan(tabungan);
       params.addAttribute("mutasi",mutasiTabungan);
       return "/pages/tabungan/form_setor";
    }

    @PostMapping("/setoran/submit")
    public  String SetoranSubmit(@Valid @ModelAttribute MutasiTabungan mutasi,
                                 BindingResult bindingResult,
                                 RedirectAttributes riderec){
        Tabungan tabungan = mutasi.getTabungan();
        mutasi.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        mutasi.setCreatedBy("admin");
        mutasi.setKeterangan("SETORAN_TABUNGAN");
        mutasi.setDebet(BigDecimal.ZERO);
        mutasi.setSaldo(mutasi.getCredit().add(tabungan.getSaldo()));
        mutasi.setTanggal(Date.valueOf(LocalDate.now()));
        this.tabunganService.setoran(mutasi);
        console.info("{}", mutasi.toString());
        riderec.addFlashAttribute("Sukses","Setoran Berhasil ditambahkan");
        return "redirect:/tabungan/detail/" + mutasi.getTabungan().getId();
    }

    @GetMapping("/tarik/{id}")
    public String TarikanForm(@ModelAttribute MutasiTabungan mutasiTabungan,
                              @PathVariable(value = "id") String idTabungan
                              ,ModelMap params) {
        Tabungan tabungan = this.tabunganService.findByid(idTabungan);
        mutasiTabungan.setTabungan(tabungan);
        params.addAttribute("mutasi",mutasiTabungan);
        return "/pages/tabungan/form_tarik";
    }

    @PostMapping("/tarik/submit")
    public  String TarikSubmit(MutasiTabungan mutasi,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        Tabungan tabungan = mutasi.getTabungan();
        mutasi.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        mutasi.setCreatedBy("admin");
        mutasi.setKeterangan("PENCAIRAN_TABUNGAN");
        mutasi.setCredit(BigDecimal.ZERO);
        mutasi.setSaldo(tabungan.getSaldo().subtract(mutasi.getDebet()));
        mutasi.setTanggal(Date.valueOf(LocalDate.now()));
        this.tabunganService.tarik(mutasi);
        redirectAttributes.addFlashAttribute("alertsukses","Tarikan Saldo secara tunai berhasil dilakukan");
        return "redirect:/tabungan/detail/" + mutasi.getTabungan().getId();
    }
}

