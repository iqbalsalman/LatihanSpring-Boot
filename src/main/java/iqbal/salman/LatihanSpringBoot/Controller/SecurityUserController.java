package iqbal.salman.LatihanSpringBoot.Controller;



import iqbal.salman.LatihanSpringBoot.master.rolesecurity.UserSecurity;
import iqbal.salman.LatihanSpringBoot.service.UserService;
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
@RequestMapping("/userSecurity")
public class SecurityUserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/", "list"})
    public String listUser(ModelMap params) {
        params.addAttribute("listsecurity", userService.findUser());
        return "/pages/UserSecurity/list";
    }


    @GetMapping("/form")
    public  String Scurityadd(UserSecurity userSecurity, ModelMap paramp){
        paramp.addAttribute("userSecurity", userSecurity);
        paramp.addAttribute("roles", userService.listRole());
        return "/pages/UserSecurity/form";
    }

    @PostMapping("/submit")
    public String submitUser(@Valid @ModelAttribute UserSecurity user, BindingResult bindingresult , RedirectAttributes redirect) {
        user.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        user.setCeatedBy("admin");
        if (bindingresult.hasErrors()) {
            return "pages/UserSecurity/form";
        }
        userService.save(user);
        redirect.addFlashAttribute("submitBerhasil", "Data Berhasil Dimasukkan!");
        return "redirect:/userSecurity/list";
    }

    @RequestMapping("/hapus/{id}")
    public String HapusUser(@PathVariable(value = "id") String id){
        userService.delete(id);
        return "redirect:/userSecurity/list";
    }

    @GetMapping("/form/{id}")
    public  String formEdit(@PathVariable (value = "id") String ida, ModelMap params, RedirectAttributes redirectAttributes) {
        UserSecurity userSecurity = userService.findById(ida);
        if (userSecurity != null) {
            params.addAttribute("userSecurity", userSecurity);
            return "/pages/UserSecurity/form";
        } else {
            redirectAttributes.addFlashAttribute("NotAvalibel", "Data Yang dicari tidak ada");
        }
        return "redirect:/userSecurity/list";

    }


}
