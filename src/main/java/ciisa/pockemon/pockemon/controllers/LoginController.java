package ciisa.pockemon.pockemon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ciisa.pockemon.pockemon.models.entities.EntrenadorEntity;

@Controller
@RequestMapping("/")
public class LoginController {
    
    @GetMapping
    public String login() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("entrenador", new EntrenadorEntity());
        return "login";
    }
}