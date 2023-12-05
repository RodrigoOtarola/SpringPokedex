package ciisa.pockemon.pockemon.models.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ciisa.pockemon.pockemon.models.PockemonEntrenadorModel;

@Repository
public interface PockemonEntrenadorRepository extends CrudRepository<PockemonEntrenadorModel, Integer> {
    
    public List<PockemonEntrenadorModel> findAllByEntrenador_idAndActivo(int entrenador_id, int estado);

    public PockemonEntrenadorModel findByIdAndActivo(int id, int e);
}
