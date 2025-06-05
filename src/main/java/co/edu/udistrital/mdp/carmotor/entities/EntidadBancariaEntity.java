package co.edu.udistrital.mdp.carmotor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class EntidadBancariaEntity extends BaseEntity{

    @OneToOne(mappedBy = "vehiculo")
    private VehiculoEntity vehiculo;

    @OneToOne
    private ImagenEntity imagen;

    private String nombre;
    private String numeroTelefonoAsesor;
}
