package ciisa.pockemon.pockemon.validations;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ciisa.pockemon.pockemon.models.entities.PockemonEntity;

@Service
public class CrearPockemonValidations implements Validator {

    @Override
    public boolean supports(Class<?> clazz) 
    {
        return PockemonEntity.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) 
    {
        ValidationUtils.rejectIfEmpty(errors, "tipoPockemon", "required.tipoPockemon", "Este campo es obligatorio");
    }

    public Map<String, String> fieldError(BindingResult result) 
    {
        Map<String, String> errores = new LinkedHashMap<>();
        for (Object object : result.getAllErrors()) {
            if (object instanceof FieldError) {
                FieldError fieldError = (FieldError) object;
                errores.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
        }
        return errores;
    }
    
}
