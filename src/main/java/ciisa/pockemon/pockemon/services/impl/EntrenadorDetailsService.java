package ciisa.pockemon.pockemon.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ciisa.pockemon.pockemon.models.entities.EntrenadorEntity;

@Service
public class EntrenadorDetailsService implements UserDetailsService {

    @Autowired
    private EntrenadorService usuarioService; // Tu repositorio que accede a los datos de usuario

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        EntrenadorEntity miUsuario = this.usuarioService.getEntrenadorByUsername(usuario); // Cambia 'findByUsername' por tu método personalizado
        if (miUsuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new User(miUsuario.getUsername(), miUsuario.getPassword(), new ArrayList<>());
    }
}
