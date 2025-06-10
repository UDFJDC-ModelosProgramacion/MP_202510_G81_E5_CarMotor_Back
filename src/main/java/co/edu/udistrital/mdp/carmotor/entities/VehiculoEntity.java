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
public class VehiculoEntity extends BaseEntity{
    @PodamExclude
    @ManyToOne
    private SedeEntity sede;

    @ManyToOne
    private AsesorVehiculoEntity asesorVehiculo;

    @OneToMany(mappedBy="vehiculo")
    private List<ImagenEntity> imagenes;

    @OneToMany(mappedBy = "vehiculo")
    private List<MantenimientoEntity> mantenimientos;

    @OneToOne(mappedBy = "vehiculo")
    private EntidadBancariaEntity entidadBancaria;

    @OneToOne(mappedBy = "vehiculo")
    private SeguroEntity seguro;
    
    private String marca;
    private String serie;
    private String placa;
    private String modelo;
    private String tipo;
    private String capacidadPasajeros;
    private Integer precio;

}
