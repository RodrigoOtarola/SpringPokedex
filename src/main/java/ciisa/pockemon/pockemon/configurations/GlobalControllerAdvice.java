package ciisa.pockemon.pockemon.configurations;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("usuarioAutenticado")
    public boolean isUsuarioAutenticado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Revisa si el usuario está autenticado y no es un usuario anónimo
        return authentication != null && authentication.isAuthenticated() 
               && !(authentication instanceof AnonymousAuthenticationToken);
    }
}

