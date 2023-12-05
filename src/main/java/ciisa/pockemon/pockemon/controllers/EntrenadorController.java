package ciisa.pockemon.pockemon.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ciisa.pockemon.pockemon.models.entities.EntrenadorEntity;
import ciisa.pockemon.pockemon.services.impl.DetallesEntrenadorService;
import ciisa.pockemon.pockemon.services.impl.EntrenadorService;
import ciisa.pockemon.pockemon.validations.EntrenadorValidations;

@Controller
@RequestMapping("/mis_datos")
public class EntrenadorController {
    
    @Autowired
    private DetallesEntrenadorService detallesEntrenadorService;

    @Autowired
    private EntrenadorValidations entrenadorValidations;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping
    public String misDatos(Model model){

        model.addAttribute("entrenador", detallesEntrenadorService.detallesEntrenador());

        return "home/entrenador/mis_datos";
    }

    @PutMapping
    public String misDatos(Model model, EntrenadorEntity entrenador, BindingResult result ){

        this.entrenadorValidations.validate(entrenador, result);
        if(result.hasErrors()){
            Map<String, String> errores = this.entrenadorValidations.fieldError(result);
            for (String e : errores.keySet()) {
                model.addAttribute("error_" + e, errores.get(e));
            }
            model.addAttribute("entrenador", detallesEntrenadorService.detallesEntrenador());
            model.addAttribute("alerta", true);
            model.addAttribute("tipo", "warning");
            model.addAttribute("titulo", "¡Atención!");
            model.addAttribute("mensaje", "No ha sido posible actualizar los datos intenta nuevamente");

            return "home/entrenador/mis_datos";
        }

        if(entrenador.getPassword() != detallesEntrenadorService.detallesEntrenador().getPassword()){
            entrenador.setPassword(this.passwordEncoder.encode(entrenador.getPassword()));
        }
        entrenador.setId(detallesEntrenadorService.detallesEntrenador().getId());
        entrenadorService.save(entrenador);

        model.addAttribute("entrenador", entrenador);
        model.addAttribute("alerta", true);
        model.addAttribute("tipo", "success");
        model.addAttribute("titulo", "¡Excelente!");
        model.addAttribute("mensaje", "Haz actualizado los datos");

        return "home/entrenador/mis_datos";
    }
}
