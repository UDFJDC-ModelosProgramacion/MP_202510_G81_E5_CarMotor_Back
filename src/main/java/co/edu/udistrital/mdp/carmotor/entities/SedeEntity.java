package co.edu.udistrital.mdp.carmotor.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Data
@Entity
public class SedeEntity extends BaseEntity{
    @PodamExclude
    @OneToMany
    private VehiculoEntity vehiculo;
    private AsesorVehiculoEntity asesorVehiculo;

    private String nombre;
    private String direccion;
    private String telefono;
    private String horario;
}
