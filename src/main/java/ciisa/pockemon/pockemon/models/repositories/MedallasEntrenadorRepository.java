package ciisa.pockemon.pockemon.models.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ciisa.pockemon.pockemon.models.MedallaEntrenadorModel;

@Repository
public interface MedallasEntrenadorRepository extends CrudRepository<MedallaEntrenadorModel, Integer> {
    
    public List<MedallaEntrenadorModel> findAllByActivo(int e);

    public MedallaEntrenadorModel findByIdAndActivo(int medallaId, int e);

    public List<MedallaEntrenadorModel> findByEntrenador_idAndActivo(int entrenadorId, int e);
}
