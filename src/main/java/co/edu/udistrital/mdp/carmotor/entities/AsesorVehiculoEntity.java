package co.edu.udistrital.mdp.carmotor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;
import java.util.List;


@Data
@Entity
public class AsesorVehiculoEntity extends BaseEntity {
    @PodamExclude
    @ManyToOne
    private SedeEntity sede;

    @OneToMany(mappedBy = "asesorVehiculo")
    private List<VehiculoEntity> vehiculos;

    @OneToOne(mappedBy = "asesorVehiculo")
    private ImagenEntity imagen;

    private String nombre;
    private String numeroContacto;
    
}
