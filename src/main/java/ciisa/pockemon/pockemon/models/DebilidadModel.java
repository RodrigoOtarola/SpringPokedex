package ciisa.pockemon.pockemon.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class DebilidadModel implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String tipo;

    private Integer debilidad;
}
