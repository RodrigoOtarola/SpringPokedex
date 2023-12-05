package ciisa.pockemon.pockemon.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ciisa.pockemon.pockemon.models.GimnasioModel;
import ciisa.pockemon.pockemon.models.repositories.GimnasioRepository;
import ciisa.pockemon.pockemon.services.IGimnasioService;

@Service
public class GimnasioService implements IGimnasioService {

    @Autowired
    private GimnasioRepository gimnasioRepository;

    @Override
    public List<GimnasioModel> getAll() {
        return this.gimnasioRepository.findAll();
    }

    @Override
    public GimnasioModel getById(int gimnasioId) {
        return this.gimnasioRepository.findById(gimnasioId);
    }
    
}
