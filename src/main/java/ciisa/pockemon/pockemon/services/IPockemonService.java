package ciisa.pockemon.pockemon.services;

import java.util.List;

import ciisa.pockemon.pockemon.models.entities.PockemonEntity;

public interface IPockemonService {
    
    public List<PockemonEntity> getAllTipoPockemon();

    public PockemonEntity getPockemonById(int pockemonId);

    public List<PockemonEntity> getPockemonTipo(String pockemonTipo);
}
