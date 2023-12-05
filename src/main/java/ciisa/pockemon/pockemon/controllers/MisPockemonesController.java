package ciisa.pockemon.pockemon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ciisa.pockemon.pockemon.models.PockemonEntrenadorModel;
import ciisa.pockemon.pockemon.models.entities.EntrenadorEntity;
import ciisa.pockemon.pockemon.models.entities.PockemonEntity;
import ciisa.pockemon.pockemon.services.impl.DetallesEntrenadorService;
import ciisa.pockemon.pockemon.services.impl.EntrenadorService;
import ciisa.pockemon.pockemon.services.impl.PockemonEntrenadorService;
import ciisa.pockemon.pockemon.services.impl.PockemonService;

@Controller
@RequestMapping("/mis_pockemones")
public class MisPockemonesController {
    
    @Autowired
    private EntrenadorService entrenadorService;

    @Autowired
    private PockemonService pockemonService;

    @Autowired
    private PockemonEntrenadorService pockemonEntrenadorService;

    @Autowired
    private DetallesEntrenadorService entrenador;


    @GetMapping
    public String pockemones(Model model){

        model.addAttribute("username", this.entrenador.detallesEntrenador().getNombre());
        model.addAttribute("pockemones", pockemonEntrenadorService.getAllPockemon(entrenador.detallesEntrenador().getId()));
        
        return "home/entrenador/listar";
    }


    @GetMapping("/crear")
    public String crear(Model model){

        this.entrenador.detallesEntrenador().setPassword("");
        PockemonEntity pockemon = new PockemonEntity();

        model.addAttribute("entrenador", this.entrenador.detallesEntrenador());
        model.addAttribute("pockemon", pockemon);
        model.addAttribute("listaPockemones", pockemonService.getAllTipoPockemon());
        
        return "home/entrenador/crear";
    }


    @PostMapping("/crear")
    public String crear(Model model, PockemonEntity pockemon){

        System.out.println(pockemon);
        System.out.println(pockemon.getId());

        PockemonEntity pockemonSeleccionado = this.pockemonService.getPockemonById(pockemon.getId());
        PockemonEntrenadorModel pockemonEntrenador = new PockemonEntrenadorModel();
        pockemonEntrenador.setActivo(1);
        pockemonEntrenador.setEnergia(pockemonSeleccionado.getEnergia());
        pockemonEntrenador.setEntrenador(this.entrenador.detallesEntrenador());
        pockemonEntrenador.setPockemon(pockemonSeleccionado);

        this.pockemonEntrenadorService.save(pockemonEntrenador);

        model.addAttribute("entrenador", entrenador);
        model.addAttribute("pockemon", new PockemonEntrenadorModel());
        model.addAttribute("listaPockemones", pockemonService.getAllTipoPockemon());
        model.addAttribute("alerta", true);
        model.addAttribute("tipo", "success");
        model.addAttribute("titulo", "¡Excelente!");
        model.addAttribute("mensaje", "Se ha agregado el pokémon exitosamente.");
        
        return "home/entrenador/crear";
    }


    @GetMapping("/editar/{pockemonEntrenadorId}")
    public String editar(Model model, @PathVariable int pockemonEntrenadorId){
            
        PockemonEntrenadorModel pockemonEntrenador = this.pockemonEntrenadorService.getById(pockemonEntrenadorId);
        PockemonEntity pockemon = this.pockemonService.getPockemonById(pockemonEntrenador.getPockemon().getId());

        model.addAttribute("pockemonEntrenadorId", pockemonEntrenadorId);
        model.addAttribute("pockemon", pockemon);
        model.addAttribute("listaPockemones", pockemonService.getAllTipoPockemon());
        
        return "home/entrenador/editar";
    }


    @PutMapping("/editar/{pockemonEntrenadorId}")
    public String editar(Model model, @PathVariable int pockemonEntrenadorId, PockemonEntity pockemonNuevo){

        PockemonEntrenadorModel pockemonEntrenador = this.pockemonEntrenadorService.getById(pockemonEntrenadorId);
        PockemonEntity pockemon = this.pockemonService.getPockemonById(pockemonNuevo.getId());

        if(pockemonEntrenador.getPockemon().getId() != pockemon.getId() ){
            pockemonEntrenador.setEnergia(pockemon.getEnergia());
        }else{
            pockemonEntrenador.setEnergia(pockemonEntrenador.getEnergia());
        }
        pockemonEntrenador.setActivo(1);
        pockemonEntrenador.setEntrenador(this.entrenador.detallesEntrenador());
        pockemonEntrenador.setPockemon(pockemon);
        
        this.pockemonEntrenadorService.save(pockemonEntrenador);

        model.addAttribute("pockemonEntrenadorId", pockemonEntrenadorId);
        model.addAttribute("pockemon", pockemon);
        model.addAttribute("listaPockemones", pockemonService.getAllTipoPockemon());
        model.addAttribute("alerta", true);
        model.addAttribute("tipo", "success");
        model.addAttribute("titulo", "¡Excelente!");
        model.addAttribute("mensaje", "Se ha actualizado tu pokémon exitosamente.");
        
        return "home/entrenador/editar";
    }


    @DeleteMapping("/{pockemon_id}")
    public String eliminar(Model model, @PathVariable int pockemon_id){
            
        PockemonEntrenadorModel pockemon = this.pockemonEntrenadorService.getById(pockemon_id);
        pockemon.setActivo(0);
        this.pockemonEntrenadorService.save(pockemon);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        String username = userDetails.getUsername();
        EntrenadorEntity entrenador = this.entrenadorService.getEntrenadorByUsername(username);

        model.addAttribute("username", entrenador.getNombre());
        model.addAttribute("pockemones", pockemonEntrenadorService.getAllPockemon(entrenador.getId()));
        
        return "home/entrenador/listar";
    }
}
