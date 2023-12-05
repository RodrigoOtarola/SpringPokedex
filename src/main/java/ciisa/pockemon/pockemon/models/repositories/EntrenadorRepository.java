package ciisa.pockemon.pockemon.models.repositories;

import org.springframework.data.repository.CrudRepository;

import ciisa.pockemon.pockemon.models.entities.EntrenadorEntity;

public interface EntrenadorRepository extends CrudRepository<EntrenadorEntity, Integer> {
    
    public EntrenadorEntity findByUsername(String username);
}
