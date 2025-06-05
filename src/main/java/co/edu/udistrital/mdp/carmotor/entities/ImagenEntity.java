package co.edu.udistrital.mdp.carmotor.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class ImagenEntity extends BaseEntity {
    @OneToMany(mappedBy = "vehiculo")
    private VehiculoEntity vehiculo;

    @OneToOne(mappedBy = "asesorVehiculo")
    private AsesorVehiculoEntity asesorVehiculo;

    @OneToOne(mappedBy = "entidadBancaria")
    private EntidadBancariaEntity entidadBancaria;

    private String url;
    private String ancho;
    private String alto;
}
