package co.edu.udistrital.mdp.carmotor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class EntidadBancariaEntity extends BaseEntity{

    @OneToOne
    private VehiculoEntity vehiculo;

    @OneToOne(mappedBy = "entidadBancaria")
    private ImagenEntity logo;

    private String nombre;
    private String numeroTelefonoAsesor;
}
