package ciisa.pockemon.pockemon.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ciisa.pockemon.pockemon.models.entities.EntrenadorEntity;
import ciisa.pockemon.pockemon.models.repositories.EntrenadorRepository;
import ciisa.pockemon.pockemon.services.IEntrenadorService;

@Service
public class EntrenadorService implements IEntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Override
    public EntrenadorEntity getEntrenadorByUsername(String username) throws UsernameNotFoundException {
        return this.entrenadorRepository.findByUsername(username);
    }

    @Override
    public EntrenadorEntity save(EntrenadorEntity entrenador) {
        return this.entrenadorRepository.save(entrenador);
    }
}
