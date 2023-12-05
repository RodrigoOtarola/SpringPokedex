package ciisa.pockemon.pockemon.services;

import java.util.List;

import ciisa.pockemon.pockemon.models.PockemonEntrenadorModel;

public interface IPockemonEntrenadorService {
    
    public List<PockemonEntrenadorModel> getAllPockemon(int entrenador_id);

    public PockemonEntrenadorModel getById(int id);

    public PockemonEntrenadorModel save(PockemonEntrenadorModel pockemon);
}
