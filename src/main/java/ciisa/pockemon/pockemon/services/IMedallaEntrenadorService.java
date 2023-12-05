package ciisa.pockemon.pockemon.services;

import java.util.List;

import ciisa.pockemon.pockemon.models.MedallaEntrenadorModel;

public interface IMedallaEntrenadorService {
    
    public List<MedallaEntrenadorModel> getAll(int e);

    public MedallaEntrenadorModel save(MedallaEntrenadorModel medallaEntrenador);

    public MedallaEntrenadorModel getById(int medallaId);

    public List<MedallaEntrenadorModel> getByEntrenadorId(int entrenadorId);
}
