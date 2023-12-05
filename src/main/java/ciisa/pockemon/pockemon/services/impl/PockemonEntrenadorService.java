package ciisa.pockemon.pockemon.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ciisa.pockemon.pockemon.models.PockemonEntrenadorModel;
import ciisa.pockemon.pockemon.models.repositories.PockemonEntrenadorRepository;
import ciisa.pockemon.pockemon.services.IPockemonEntrenadorService;

@Service
public class PockemonEntrenadorService implements IPockemonEntrenadorService {

    @Autowired
    private PockemonEntrenadorRepository pockemonRepository;

    @Override
    public List<PockemonEntrenadorModel> getAllPockemon(int entrenador_id) {
        return this.pockemonRepository.findAllByEntrenador_idAndActivo(entrenador_id, 1);
    }

    @Override
    public PockemonEntrenadorModel save(PockemonEntrenadorModel pockemon) {
        return this.pockemonRepository.save(pockemon);
    }

    @Override
    public PockemonEntrenadorModel getById(int id) {
        return this.pockemonRepository.findByIdAndActivo(id,1);
    }
    
}
