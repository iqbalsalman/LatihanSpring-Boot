package iqbal.salman.LatihanSpringBoot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginConntroller {

    @GetMapping(value = {"/login"})
    public String LoginUser(ModelMap params){
        params.addAttribute("login");
        return "/pages/UserSecurity/login";
    }
}
