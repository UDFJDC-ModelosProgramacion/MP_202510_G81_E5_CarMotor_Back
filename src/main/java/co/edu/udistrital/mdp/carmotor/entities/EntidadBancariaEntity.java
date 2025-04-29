package co.edu.udistrital.mdp.carmotor.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class EntidadBancariaEntity extends BaseEntity{
    private String nombre;
    private String numeroTelefonoAsesor;
}
