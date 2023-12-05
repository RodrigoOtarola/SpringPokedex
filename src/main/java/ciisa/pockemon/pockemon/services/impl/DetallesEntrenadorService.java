package ciisa.pockemon.pockemon.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import ciisa.pockemon.pockemon.models.entities.EntrenadorEntity;
import ciisa.pockemon.pockemon.services.IDetallesEntrenadorService;

@Service
public class DetallesEntrenadorService implements IDetallesEntrenadorService {

    @Autowired
    private EntrenadorService entrenadorService;

    @Override
    public EntrenadorEntity detallesEntrenador() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        String username = userDetails.getUsername();
        EntrenadorEntity entrenador = this.entrenadorService.getEntrenadorByUsername(username);

        return entrenador;
    }
    
}
