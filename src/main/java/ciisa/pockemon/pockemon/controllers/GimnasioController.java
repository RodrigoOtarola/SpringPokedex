package ciisa.pockemon.pockemon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ciisa.pockemon.pockemon.models.GimnasioModel;
import ciisa.pockemon.pockemon.models.MedallaEntrenadorModel;
import ciisa.pockemon.pockemon.models.PockemonEntrenadorModel;
import ciisa.pockemon.pockemon.models.entities.EntrenadorEntity;
import ciisa.pockemon.pockemon.services.impl.DetallesEntrenadorService;
import ciisa.pockemon.pockemon.services.impl.GimnasioService;
import ciisa.pockemon.pockemon.services.impl.MedallaEntrenadorService;
import ciisa.pockemon.pockemon.services.impl.PockemonEntrenadorService;

@Controller
@RequestMapping("/gimnasio")
public class GimnasioController {

    @Autowired
    private GimnasioService gimnasioService;

    @Autowired
    private DetallesEntrenadorService detallesEntrenadorService;

    @Autowired
    private PockemonEntrenadorService pockemonEntrenadorService;
    
    @Autowired
    private MedallaEntrenadorService medallaEntrenadorService;
    
    @GetMapping
    public String gimnasio(Model model){

        EntrenadorEntity entrenador = this.detallesEntrenadorService.detallesEntrenador();
        List<MedallaEntrenadorModel> medallaEntrenador = this.medallaEntrenadorService.getByEntrenadorId(entrenador.getId());

        model.addAttribute("medallasEntrenador", medallaEntrenador);
        model.addAttribute("gimnasios", this.gimnasioService.getAll());

        return "home/gimnasio/listar";
    }

    @GetMapping("/combatir/{gimnasioId}")
    public String combatir(Model model, @PathVariable int gimnasioId){
        
        EntrenadorEntity entrenador = detallesEntrenadorService.detallesEntrenador();
        GimnasioModel gimnasio = this.gimnasioService.getById(gimnasioId);

        List<PockemonEntrenadorModel> pockemonEntrenador = pockemonEntrenadorService.getAllPockemon(entrenador.getId());

        model.addAttribute("nombreUsuario", detallesEntrenadorService.detallesEntrenador().getNombre());
        model.addAttribute("contrincante", gimnasio.getNombreEntrenador());
        model.addAttribute("misPockemones", pockemonEntrenador);
        model.addAttribute("pockemon", new PockemonEntrenadorModel());
        model.addAttribute("gimnasio", gimnasio);
        return "home/gimnasio/combatir";
    }
}
