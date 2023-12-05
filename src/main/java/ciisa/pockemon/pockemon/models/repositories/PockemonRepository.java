package ciisa.pockemon.pockemon.models.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ciisa.pockemon.pockemon.models.entities.PockemonEntity;

@Repository
public interface PockemonRepository extends CrudRepository<PockemonEntity, Integer> {
    
    public List<PockemonEntity> findAllByOrderByTipo();

    public PockemonEntity findById(int pockemonId);

    public List<PockemonEntity> findByTipo(String tipoPockemon);
}
