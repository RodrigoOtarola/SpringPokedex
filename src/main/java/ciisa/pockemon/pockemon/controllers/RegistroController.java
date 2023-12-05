package ciisa.pockemon.pockemon.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ciisa.pockemon.pockemon.models.entities.EntrenadorEntity;
import ciisa.pockemon.pockemon.services.impl.EntrenadorService;
import ciisa.pockemon.pockemon.validations.EntrenadorValidations;

@Controller
@RequestMapping("/register")
public class RegistroController {

    @Autowired
    private EntrenadorService entrenadorServices;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EntrenadorValidations entrenadorValidations;

    @GetMapping
    public String getRegisterForm(Model model) {
        
        model.addAttribute("entrenador", new EntrenadorEntity());

        return "register";
    }

    @PostMapping
    public String registerUser(Model model,EntrenadorEntity entrenador, BindingResult result) {
        this.entrenadorValidations.validate(entrenador, result);
        if(result.hasErrors()){
            Map<String, String> errores = this.entrenadorValidations.fieldError(result);
            for (String e : errores.keySet()) {
                model.addAttribute("error_" + e, errores.get(e));
            }
            model.addAttribute("entrenador", entrenador);
            return "register";
        }
        entrenador.setPassword(this.passwordEncoder.encode(entrenador.getPassword()));
        entrenador.setUsername(entrenador.getUsername().replace(" ", "").toLowerCase());
        this.entrenadorServices.save(entrenador);

        model.addAttribute("alerta", true);
        model.addAttribute("tipo", "success");
        model.addAttribute("titulo", "¡Excelente!");
        model.addAttribute("mensaje", "Registrado correctamente tu nombre de usuario es: " + entrenador.getUsername());

        return "redirect:/login";
    }
}

