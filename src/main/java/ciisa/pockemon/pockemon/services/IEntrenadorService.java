package ciisa.pockemon.pockemon.services;

import ciisa.pockemon.pockemon.models.entities.EntrenadorEntity;

public interface IEntrenadorService {
    
    public EntrenadorEntity getEntrenadorByUsername(String username);

    public EntrenadorEntity save(EntrenadorEntity entrenador);
}
