package ciisa.pockemon.pockemon.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ciisa.pockemon.pockemon.models.entities.EntrenadorEntity;
import ciisa.pockemon.pockemon.models.entities.PockemonEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "pockemon_entrenador")
public class PockemonEntrenadorModel implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "entrenador_id")
    private EntrenadorEntity entrenador;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "pockemon_id")
    private PockemonEntity pockemon;

    @Column(name = "activo")
    private Integer activo;

    @Column(name = "energia")
    private Integer energia;
}
