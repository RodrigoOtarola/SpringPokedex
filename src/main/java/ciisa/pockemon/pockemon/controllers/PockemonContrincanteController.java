package ciisa.pockemon.pockemon.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import ciisa.pockemon.pockemon.models.AtaqueModel;
import ciisa.pockemon.pockemon.models.DebilidadModel;
import ciisa.pockemon.pockemon.models.GimnasioModel;
import ciisa.pockemon.pockemon.models.MedallaEntrenadorModel;
import ciisa.pockemon.pockemon.models.PockemonEntrenadorModel;
import ciisa.pockemon.pockemon.models.entities.EntrenadorEntity;
import ciisa.pockemon.pockemon.models.entities.PockemonEntity;
import ciisa.pockemon.pockemon.services.impl.DetallesEntrenadorService;
import ciisa.pockemon.pockemon.services.impl.GimnasioService;
import ciisa.pockemon.pockemon.services.impl.MedallaEntrenadorService;
import ciisa.pockemon.pockemon.services.impl.PockemonEntrenadorService;
import ciisa.pockemon.pockemon.services.impl.PockemonService;

@RestController
@RequestMapping("/mi_pockemon")
public class PockemonContrincanteController {
    
    @Autowired
    private PockemonEntrenadorService pockemonEntrenadorService;

    @Autowired
    private GimnasioService gimnasioService;

    @Autowired
    private PockemonService pockemonService;

    @Autowired
    private DetallesEntrenadorService detallesEntrenadorService;

    @Autowired
    private MedallaEntrenadorService medallaEntrenadorService;

    @GetMapping("/{pockemonId}/{gimnasioId}")
    public Object pockemon(@PathVariable("pockemonId") int pockemonId, @PathVariable("gimnasioId") int gimnasioId){
        
        PockemonEntrenadorModel pockemonEntrenador = this.pockemonEntrenadorService.getById(pockemonId);
        Gson gson = new Gson();
        
        AtaqueModel ataque = gson.fromJson(pockemonEntrenador.getPockemon().getAtaque(), AtaqueModel.class);
        DebilidadModel debilidad = gson.fromJson(pockemonEntrenador.getPockemon().getDebilidad(), DebilidadModel.class);

        Map<String,String> result = new LinkedHashMap<>();      
        //mi pockemon
        result.put("pockemon1", pockemonEntrenador.getPockemon().getNombre());
        result.put("ataqueNombre1", ataque.getNombre());
        result.put("ataquePotencia1",ataque.getPotencia() + "");
        result.put("debilidadNombre1", debilidad.getTipo());
        result.put("debilidadPotencia1", debilidad.getDebilidad() + "");
        result.put("tipo1", pockemonEntrenador.getPockemon().getTipo());
        result.put("energia1", pockemonEntrenador.getEnergia() + "");
        result.put("entrenadorId", this.detallesEntrenadorService.detallesEntrenador().getId() + "");

        //contrincante
        GimnasioModel gimnasio = this.gimnasioService.getById(gimnasioId);
        List<PockemonEntity> listaPockemonContrincantes = this.pockemonService.getPockemonTipo(gimnasio.getTipoPockemon());
        int min = 0;
        int max = 2;
        Integer numeroAleatorio = min + (int)(Math.random() * ((max - min) + 1));
        PockemonEntity pockemonContrincante = listaPockemonContrincantes.get(numeroAleatorio);

        AtaqueModel ataque2 = gson.fromJson(pockemonContrincante.getAtaque(), AtaqueModel.class);
        DebilidadModel debilidad2 = gson.fromJson(pockemonContrincante.getDebilidad(), DebilidadModel.class);

        result.put("pockemon2", pockemonContrincante.getNombre());
        result.put("ataqueNombre2", ataque2.getNombre());
        result.put("ataquePotencia2",ataque2.getPotencia() + "");
        result.put("debilidadNombre2", debilidad2.getTipo());
        result.put("debilidadPotencia2", debilidad2.getDebilidad() + "");
        result.put("tipo2", pockemonContrincante.getTipo());
        result.put("energia2", pockemonContrincante.getEnergia() + "");
        
        return result; 
    }

    @GetMapping("/medalla/{entrenadorId}/{gimnasioId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void registrarMedalla(@PathVariable("entrenadorId") int entrenadorId, @PathVariable("gimnasioId") int gimnasioId){

        EntrenadorEntity entrenador = this.detallesEntrenadorService.detallesEntrenador();

        GimnasioModel gimnasio = this.gimnasioService.getById(gimnasioId);

        MedallaEntrenadorModel medallaEntrenador = new MedallaEntrenadorModel();

        medallaEntrenador.setActivo(1);
        medallaEntrenador.setEntrenador(entrenador);
        medallaEntrenador.setGimnasio(gimnasio);

        this.medallaEntrenadorService.save(medallaEntrenador);
    }
}
