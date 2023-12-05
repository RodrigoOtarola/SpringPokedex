package ciisa.pockemon.pockemon.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "gimnasio")
public class GimnasioModel implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_medalla")
    private String nombreMedalla;

    @Column(name = "alias_medalla")
    private String aliasMedalla;

    @Column(name = "nombre_gimnasio")
    private String nombreGimnasio;

    @Column(name = "nombre_entrenador")
    private String nombreEntrenador;

    @Column(name = "tipo_pockemon")
    private String tipoPockemon;

    @JsonBackReference
    @OneToMany(mappedBy = "gimnasio")
    private Set<MedallaEntrenadorModel> medallasEntrenador ;
}
