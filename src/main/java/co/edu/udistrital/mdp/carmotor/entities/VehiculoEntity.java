package co.edu.udistrital.mdp.carmotor.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Data
@Entity
public class VehiculoEntity extends BaseEntity{
    @PodamExclude
    @OneToMany(mappedBy = "sede")
    private SedeEntity sede;

    @OneToMany(mappedBy = "asesorVehiculo")
    private AsesorVehiculoEntity asesorVehiculo;

    @OneToMany
    private ImagenEntity imagen;

    @OneToMany
    private MantenimientoEntity mantenimiento;

    @OneToOne
    private EntidadBancariaEntity entidadBancaria;

    @OneToOne
    private SeguroEntity seguro;
    
    private String marca;
    private String serie;
    private String placa;
    private String modelo;
    private String tipo;
    private String capacidadPasajeros;
    private Integer precio;

}
