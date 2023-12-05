package ciisa.pockemon.pockemon.services;

import java.util.List;

import ciisa.pockemon.pockemon.models.GimnasioModel;

public interface IGimnasioService {
    
    public List<GimnasioModel> getAll();

    public GimnasioModel getById(int gimnasioId);
}
