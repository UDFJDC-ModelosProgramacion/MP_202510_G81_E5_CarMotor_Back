package co.edu.udistrital.mdp.carmotor.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class MantenimientoEntity extends BaseEntity{
    
    private String fechaDeServicio;
    private String tipoDeServicio;
}
