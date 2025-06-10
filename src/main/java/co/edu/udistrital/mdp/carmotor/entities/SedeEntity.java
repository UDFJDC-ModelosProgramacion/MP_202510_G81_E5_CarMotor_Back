package co.edu.udistrital.mdp.carmotor.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;
import java.util.List;

@Data
@Entity
public class SedeEntity extends BaseEntity{
    @PodamExclude

    @OneToMany(mappedBy = "sede")
    private List<VehiculoEntity> vehiculos;
    @OneToMany(mappedBy = "sede")
    private List<AsesorVehiculoEntity> asesores;

    private String nombre;
    private String direccion;
    private String telefono;
    private String horario;
    private boolean activa;
    private String capacidadmaxima;
}
