package co.edu.udistrital.mdp.carmotor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Data
@Entity
public class AsesorVehiculoEntity extends BaseEntity {
    @PodamExclude
    @OneToMany(mappedBy = "sede")
    private SedeEntity sede;

    @OneToMany
    private VehiculoEntity vehiculo;

    @OneToOne
    private ImagenEntity imagen;

    private String nombre;
    private String numeroContacto;
}
