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

import ciisa.pockemon.pockemon.models.MedallaEntrenadorModel;
import ciisa.pockemon.pockemon.models.PockemonEntrenadorModel;
import lombok.Data;

@Data
@Entity
@Table(name = "entrenador")
public class EntrenadorEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @JsonBackReference
    @OneToMany(mappedBy = "entrenador")
    private Set<PockemonEntrenadorModel> pockemones;

    @JsonBackReference
    @OneToMany(mappedBy = "entrenador")
    private Set<MedallaEntrenadorModel> medallasEntrenador;        
}
