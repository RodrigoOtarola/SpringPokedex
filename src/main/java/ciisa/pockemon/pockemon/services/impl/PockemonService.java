package ciisa.pockemon.pockemon.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ciisa.pockemon.pockemon.models.entities.PockemonEntity;
import ciisa.pockemon.pockemon.models.repositories.PockemonRepository;
import ciisa.pockemon.pockemon.services.IPockemonService;

@Service
public class PockemonService implements IPockemonService {

    @Autowired
    private PockemonRepository pockemonRepository;

    @Override
    public List<PockemonEntity> getAllTipoPockemon() {
        return this.pockemonRepository.findAllByOrderByTipo();
    }

    @Override
    public PockemonEntity getPockemonById(int pockemonId) {
        return this.pockemonRepository.findById(pockemonId);
    }

    @Override
    public List<PockemonEntity> getPockemonTipo(String pockemonTipo) {
        return this.pockemonRepository.findByTipo(pockemonTipo);
    }
    
}
