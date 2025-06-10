package co.edu.udistrital.mdp.carmotor.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class ImagenEntity extends BaseEntity {
    @ManyToOne
    private VehiculoEntity vehiculo;

    @OneToOne
    private AsesorVehiculoEntity asesorVehiculo;

    @OneToOne
    private EntidadBancariaEntity entidadBancaria;

    private String url;
    private String ancho;
    private String alto;
}
