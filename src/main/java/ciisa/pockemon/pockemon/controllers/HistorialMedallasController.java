package ciisa.pockemon.pockemon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ciisa.pockemon.pockemon.models.MedallaEntrenadorModel;
import ciisa.pockemon.pockemon.models.entities.EntrenadorEntity;
import ciisa.pockemon.pockemon.services.impl.DetallesEntrenadorService;
import ciisa.pockemon.pockemon.services.impl.MedallaEntrenadorService;

@Controller
@RequestMapping("/medallas")
public class HistorialMedallasController {

    @Autowired
    private DetallesEntrenadorService detallesEntrenadorService;

    @Autowired
    private MedallaEntrenadorService medallaEntrenadorService;
   
    @GetMapping
    public String listar(Model model){

        EntrenadorEntity entrenador = this.detallesEntrenadorService.detallesEntrenador();
        List<MedallaEntrenadorModel> medallasEntrenador = this.medallaEntrenadorService.getByEntrenadorId(entrenador.getId());
        
        model.addAttribute("nombre", entrenador.getNombre());
        model.addAttribute("medallasEntrenador", medallasEntrenador);

        return "home/medallas/listar";
    }

    @DeleteMapping("/{medallaId}")
    public String eliminar(@PathVariable int medallaId, Model model) {
    
        MedallaEntrenadorModel medallaEntrenador = medallaEntrenadorService.getById(medallaId);
        medallaEntrenador.setActivo(0);
        this.medallaEntrenadorService.save(medallaEntrenador);

        EntrenadorEntity entrenador = this.detallesEntrenadorService.detallesEntrenador();
        List<MedallaEntrenadorModel> medallasEntrenador = this.medallaEntrenadorService.getByEntrenadorId(entrenador.getId());

        model.addAttribute("nombre", entrenador.getNombre());
        model.addAttribute("medallasEntrenador", medallasEntrenador);
        model.addAttribute("entrenador", entrenador);
        model.addAttribute("alerta", true);
        model.addAttribute("tipo", "success");
        model.addAttribute("titulo", "¡Excelente!");
        model.addAttribute("mensaje", "Se ha eliminado la medalla exitosamente.");

        return "home/medallas/listar";
    }
}
