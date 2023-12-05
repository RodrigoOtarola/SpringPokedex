package ciisa.pockemon.pockemon.models.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ciisa.pockemon.pockemon.models.GimnasioModel;

@Repository
public interface GimnasioRepository extends CrudRepository<GimnasioModel, Integer> {

    public List<GimnasioModel> findAll();

    public GimnasioModel findById(int gimnasioId);

}
