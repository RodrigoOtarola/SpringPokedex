package ciisa.pockemon.pockemon.models.entities;

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

import ciisa.pockemon.pockemon.models.PockemonEntrenadorModel;
import lombok.Data;

@Data
@Entity
@Table(name = "pockemon")
public class PockemonEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "energia")
    private Integer energia;

    @Column(name = "debilidad")
    private String debilidad;

    @Column(name = "ataque")
    private String ataque;

    @JsonBackReference
    @OneToMany(mappedBy = "pockemon")
    private Set<PockemonEntrenadorModel> pockemones;

}
