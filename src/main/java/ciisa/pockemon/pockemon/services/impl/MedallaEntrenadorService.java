package ciisa.pockemon.pockemon.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ciisa.pockemon.pockemon.models.MedallaEntrenadorModel;
import ciisa.pockemon.pockemon.models.repositories.MedallasEntrenadorRepository;
import ciisa.pockemon.pockemon.services.IMedallaEntrenadorService;

@Service
public class MedallaEntrenadorService implements IMedallaEntrenadorService {

    @Autowired
    private MedallasEntrenadorRepository medallasEntrenadorRepository;

    @Override
    public List<MedallaEntrenadorModel> getAll(int e) {
        return this.medallasEntrenadorRepository.findAllByActivo(e);
    }

    @Override
    public MedallaEntrenadorModel save(MedallaEntrenadorModel medallaEntrenador) {
        return this.medallasEntrenadorRepository.save(medallaEntrenador);
    }

    @Override
    public MedallaEntrenadorModel getById(int medallaId) {
        return this.medallasEntrenadorRepository.findByIdAndActivo(medallaId, 1);
    }

    @Override
    public List<MedallaEntrenadorModel> getByEntrenadorId(int entrenadorId) {
        return this.medallasEntrenadorRepository.findByEntrenador_idAndActivo(entrenadorId,1);
    }
    
}
